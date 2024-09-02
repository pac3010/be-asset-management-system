package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.handler.Utils;
import com.example.demo.model.Asset;

import com.example.demo.model.User;
import com.example.demo.service.AssetService;
import com.example.demo.service.AssetTransactionService;
import com.example.demo.service.AssetTypeService;
import com.example.demo.model.AssetComponent;
import com.example.demo.model.AssetTransaction;
import com.example.demo.model.AssetType;
import com.example.demo.model.DamageAssessment;
import com.example.demo.model.Status;
import com.example.demo.model.dto.AssetComponentDTO;
import com.example.demo.model.dto.DamageAssessmentDTO;
import com.example.demo.service.AssetComponentService;
import com.example.demo.service.AssetTransactionService;
import com.example.demo.service.DamageAssessmentService;

import com.example.demo.service.EmailService;
import com.example.demo.service.StatusService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("api/asset")
public class AssetRestController {
    @Autowired
    private AssetTransactionService assetTransactionService;

    @Autowired
    private UserService userService;
   
    @Autowired
    private StatusService statusService;

    @Autowired
    private AssetService assetService;

    @Autowired
    private AssetTypeService assetTypeService;
  
    @Autowired
    private EmailService emailService;

    @Autowired
    private AssetComponentService assetComponentService;

    @Autowired
    private DamageAssessmentService damageAssessmentService;

// Mock Rest API untuk create request peminjaman
    @PostMapping("createRequest/{id}")
    public ResponseEntity<Object> save(@RequestBody AssetTransaction assetTransaction, @PathVariable Integer id){

         assetTransaction.setUser(userService.get(id));
 
        String assetName = assetTransaction.getAsset().getName();
        assetTransaction.setAsset(assetService.getIdByName(assetName));

        assetTransaction.setReqBorrowTime(LocalDateTime.now());

        assetTransaction.setStatus(statusService.getIdByName("Waiting For Manager Approval"));
        assetTransaction.setAdmin(userService.get(1));
        assetTransactionService.save(assetTransaction);
        return ResponseEntity.ok("Asset Create Request!");
    }

    // // Mock Rest API untuk admin menerima request
    @PostMapping("/approve/{id}")
    public ResponseEntity<Object> approveTransaction(@PathVariable Integer id) {
        Status approvedStatusId = statusService.getIdByName("Approved");
        assetTransactionService.updateStatus(id, approvedStatusId.getId());
        return Utils.generateResponseEntity(HttpStatus.OK, "Request Acc By Admin");
    }   
    

    // Mock Rest API untuk admin menolak request
    @PostMapping("/reject/{id}")
    public ResponseEntity<Object> rejectTranscation(@PathVariable Integer id) {
        Status approvedStatusId = statusService.getIdByName("Request Rejecteed by Admin");
        assetTransactionService.updateStatus(id, approvedStatusId.getId());
        return Utils.generateResponseEntity(HttpStatus.OK, "Request Reject By Admin");
    }


    // Mock Rest API untuk Create Asset admin 
     @PostMapping("/create")
    public ResponseEntity<Object> createAsset(@RequestBody Asset asset) {
        boolean saved = assetService.save(asset);
        return Utils.generateResponseEntity(HttpStatus.CREATED, "Asset created successfully", saved);
    }


    // API to update an existing Asset
    @PostMapping("/edit/{id}")
    public ResponseEntity<Object> editAsset(@PathVariable Integer id, @RequestBody Asset assetDetails) {
        Asset updatedAsset = assetService.updateAsset(id, assetDetails);
        return Utils.generateResponseEntity(HttpStatus.OK, "Asset updated successfully", updatedAsset);
    }

    // Request return from borrower to admin.
    @GetMapping("/request/return/{transactionId}")
    public ResponseEntity<Object> requestReturn(@PathVariable Integer transactionId) {
        AssetTransaction assetTransaction = assetTransactionService.get(transactionId);
        if (assetTransaction != null) {
            assetTransaction.setReqReturnTime(LocalDateTime.now());
            assetTransaction.setStatus(statusService.getIdByName("Waiting for return approval"));
            assetTransactionService.save(assetTransaction);

            String adminEmail = assetTransaction.getAdmin().getEmployee().getEmail();
            String subject = "Approval Return Request";
            String employeeUname = userService.get(assetTransaction.getUser().getId()).getUsername();
            String message = employeeUname
                    + " has requested to return the asset. Please review and process the return.";
            emailService.sendEmail(adminEmail, subject, message);
            return Utils.generateResponseEntity(HttpStatus.OK,
                    "Return request has been sent, please wait for the approval");
        }
        return Utils.generateResponseEntity(HttpStatus.OK, "Data not Found");
    }

    // Accept return request
    @GetMapping("/request/return/{transactionId}/accept")
    public ResponseEntity<Object> acceptReturn(@PathVariable Integer transactionId) {
        AssetTransaction assetTransaction = assetTransactionService.get(transactionId);
        if (assetTransaction != null) {
            Status status = statusService.getIdByName("Waiting for component assessment");
            assetTransaction.setStatus(status);
            assetTransactionService.save(assetTransaction);
            return Utils.generateResponseEntity(HttpStatus.OK, "Request Success, The status has been changed");
        }
        return Utils.generateResponseEntity(HttpStatus.OK, "Data not Found");
    }

    //Getting components
    @GetMapping("/assessment/{transactionId}")
    public ResponseEntity<Object> components(@PathVariable Integer transactionId) {
        AssetTransaction assetTransaction = assetTransactionService.get(transactionId);
        if (assetTransaction != null) {
            Asset asset = assetTransaction.getAsset();
            AssetType assetType = asset.getAssetType();
            Integer assetTypeId = assetType.getId();
            List<AssetComponent> components = assetComponentService.getComponentAsset(assetTypeId);
            List<AssetComponentDTO> assetComponentsDTO = components.stream()
                    .map(AssetComponentDTO::new)
                    .collect(Collectors.toList());
            return Utils.generateResponseEntity(HttpStatus.OK, "Component successfully Retrieved!", assetComponentsDTO);
        }
        return Utils.generateResponseEntity(HttpStatus.OK, "Data not Found");
    }

    //Assessing component's asset by admin
    @PostMapping("/assessment/{transactionId}/submit")
    public ResponseEntity<Object> submitAssessment(@PathVariable Integer transactionId,
            @RequestBody List<DamageAssessmentDTO> assessmentDTOs) {
        AssetTransaction assetTransaction = assetTransactionService.get(transactionId);
        if (assetTransaction == null) {
            return Utils.generateResponseEntity(HttpStatus.BAD_REQUEST, "Transaction not found.");
        }

        double totalDamagePercentage = 0.0;
        int count = 0;

        for (DamageAssessmentDTO assessmentDTO : assessmentDTOs) {
            AssetComponent assetComponent = assetComponentService.get(assessmentDTO.getAssetComponentId());
            if (assetComponent == null) {
                return Utils.generateResponseEntity(HttpStatus.BAD_REQUEST, "Invalid component ID.");
            }

            DamageAssessment assessment = new DamageAssessment();
            assessment.setAssetTransaction(assetTransaction);
            assessment.setAssetComponent(assetComponent);
            assessment.setIsBroken(assessmentDTO.getIsBroken());

            if (assessmentDTO.getIsBroken()) {
                totalDamagePercentage += assetComponent.getDamagePercentage();
            }
            count++;
            damageAssessmentService.save(assessment);
        }

        double averageDamagePercentage = (count > 0) ? (totalDamagePercentage / count) : 0.0;

        if (averageDamagePercentage > 10) {
            Status status = statusService.getIdByName("Damaged upon return");
            assetTransaction.setStatus(status);
        } else {
            Status status = statusService.getIdByName("Returned");
            assetTransaction.setStatus(status);
        }
        assetTransaction.setReturnTime(LocalDateTime.now());
        assetTransactionService.save(assetTransaction);
        return Utils.generateResponseEntity(HttpStatus.OK, "Assessment completed successfully.");
    }


}
