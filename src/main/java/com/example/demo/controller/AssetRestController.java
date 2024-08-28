package com.example.demo.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.handler.Utils;
import com.example.demo.model.AssetTransaction;
import com.example.demo.model.User;
import com.example.demo.service.AssetTransactionService;
import com.example.demo.service.EmailService;
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

    @GetMapping("/request/return/{transactionId}")
    public ResponseEntity<Object> requestReturn(@PathVariable Integer transactionId){
        AssetTransaction assetTransaction = assetTransactionService.get(transactionId);
        if(assetTransaction != null){
            assetTransaction.setReqReturnTime(LocalDateTime.now());
            assetTransaction.setIsReturnApproved(false);

            String adminEmail = assetTransaction.getAdmin().getEmployee().getEmail();
            String subject = "Approval Return Request";
            String employeeName = userService.get(assetTransaction.getUser().getId()).getUsername();
            String message = employeeName + " has requested to return the asset. Please review and process the return.";
            emailService.sendEmail(adminEmail, subject, message);
            return Utils.generateResponseEntity(HttpStatus.OK, "Return request has been sent, please wait for the approval", assetTransaction);
        }
        return Utils.generateResponseEntity(HttpStatus.OK, "Data not Found");
    }
}
