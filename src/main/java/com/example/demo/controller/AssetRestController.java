package com.example.demo.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.handler.Utils;
import com.example.demo.model.Asset;
import com.example.demo.model.AssetTransaction;
import com.example.demo.model.AssetType;
import com.example.demo.model.Status;
import com.example.demo.model.User;
import com.example.demo.service.AssetService;
import com.example.demo.service.AssetTransactionService;
import com.example.demo.service.AssetTypeService;
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
    // @Autowired
    // private EmailService emailService;

//     @GetMapping("/request/return/{transactionId}")
//     public ResponseEntity<Object> requestReturn(@PathVariable Integer transactionId){
//         AssetTransaction assetTransaction = assetTransactionService.get(transactionId);
//         if(assetTransaction != null){
//             assetTransaction.setReqReturnTime(LocalDateTime.now());
//             assetTransaction.setIsReturnApproved(false);
//             assetTransactionService.save(assetTransaction);

//             String adminEmail = assetTransaction.getAdmin().getEmployee().getEmail();
//             String subject = "Approval Return Request";  
//             String employeeName = userService.get(assetTransaction.getUser().getId()).getUsername();
//             String message = employeeName + " has requested to return the asset. Please review and process the return.";
//             emailService.sendEmail(adminEmail, subject, message);
//             return Utils.generateResponseEntity(HttpStatus.OK, "Return request has been sent, please wait for the approval");
//         }
//         return Utils.generateResponseEntity(HttpStatus.OK, "Data not Found");
//     }

// Mock Rest API untuk create request peminjaman
    @PostMapping("createRequest/{id}")
    public ResponseEntity<Object> save(@RequestBody AssetTransaction assetTransaction, @PathVariable Integer id){

         // Ambil user ID yang sedang login
         assetTransaction.setUser(userService.get(id));

        //  ambil asset ID by name 
        String assetName = assetTransaction.getAsset().getName();
        assetTransaction.setAsset(assetService.getIdByName(assetName));

        //  ambil waktu bororow request real nya  saat user melakukan request
        assetTransaction.setReqBorrowTime(LocalDateTime.now());

        // mendapatkan status ID 5 
        assetTransaction.setStatus(statusService.getIdByName("Waiting For Manager Approval"));

        // mendapatkan admin dengan ID 1
        assetTransaction.setAdmin(userService.get(1));

        // save semua variabel yang sudah di set dan diinputkan
        assetTransactionService.save(assetTransaction);

        // return berhasil create asset request
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


}
