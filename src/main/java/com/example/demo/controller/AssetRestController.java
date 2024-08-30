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
import com.example.demo.model.AssetComponent;
import com.example.demo.model.AssetTransaction;
import com.example.demo.model.AssetType;
import com.example.demo.model.dto.AssetAssessmentDTO;
import com.example.demo.model.dto.AssetComponentDTO;
import com.example.demo.service.AssetComponentService;
import com.example.demo.service.AssetService;
import com.example.demo.service.AssetTransactionService;
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
    private EmailService emailService;

    @Autowired
    private StatusService statusService;

    @Autowired
    private AssetComponentService assetComponentService;

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

    @PostMapping("/assessment/{transactionId}")
    public ResponseEntity<Object> performAssessment(@PathVariable Integer transactionId,
            @RequestBody AssetAssessmentDTO assetAssessmentDTO) {
        AssetTransaction assetTransaction = assetTransactionService.get(transactionId);
        if (assetTransaction == null) {
            return Utils.generateResponseEntity(HttpStatus.BAD_REQUEST, "Invalid transaction ID.");
        }

        Asset asset = assetTransaction.getAsset();
        AssetType assetType = asset.getAssetType();
        Integer assetTypeId = assetType.getId();

        List<AssetComponent> components = assetComponentService.getComponentAsset(assetTypeId);
        List<AssetComponentDTO> assetComponentsDTO = components.stream()
                .map(AssetComponentDTO::new)
                .collect(Collectors.toList());

        

        return Utils.generateResponseEntity(HttpStatus.OK, "Assessment completed successfully.");
    }

}
