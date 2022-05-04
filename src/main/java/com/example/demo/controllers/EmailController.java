package com.example.demo.controllers;


import com.example.demo.dto.EmailDTO;
import com.example.demo.models.BuyerEmailModel;
import com.example.demo.models.EmailModel;
import com.example.demo.models.SellerEmailModel;
import com.example.demo.services.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;


    @PostMapping("/mail-to-buyer")
    public ResponseEntity<BuyerEmailModel> sendingMailToBuyer(@RequestBody @Valid EmailDTO emailDTO){
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDTO,emailModel);
        BuyerEmailModel buyerEmail = emailService.sendEmailToBuyer(emailModel);
        return new ResponseEntity<>(buyerEmail, HttpStatus.CREATED);
    }

    @PostMapping("/mail-to-seller")
    public ResponseEntity<SellerEmailModel> sendingMailToSeller(@RequestBody @Valid EmailDTO emailDTO){
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDTO,emailModel);
        SellerEmailModel sellerEmail = emailService.sendEmailToSeller(emailModel);
        return new ResponseEntity<>(sellerEmail, HttpStatus.CREATED);
    }


}
