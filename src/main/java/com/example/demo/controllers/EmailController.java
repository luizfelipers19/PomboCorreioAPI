package com.example.demo.controllers;


import com.example.demo.dto.EmailDTO;
import com.example.demo.models.BuyerEmailModel;
import com.example.demo.models.EmailModel;
import com.example.demo.models.SellerEmailModel;
import com.example.demo.services.EmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(value = "Notifications")
public class EmailController {

    @Autowired
    EmailService emailService;

    @ApiOperation(value = "This endpoint creates an inbound order thats supply all warehouse of the storage app.")
    @PostMapping("/buyer-action-notify")
    public ResponseEntity<BuyerEmailModel> sendingMailToBuyer(@RequestBody @Valid EmailDTO emailDTO){
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDTO,emailModel);
        BuyerEmailModel buyerEmail = emailService.sendEmailToBuyer(emailModel, "buy");
        return new ResponseEntity<>(buyerEmail, HttpStatus.CREATED);
    }

    @PostMapping("/buyer-registration-notify")
    public ResponseEntity<BuyerEmailModel> notifyBuyerRegistration(@RequestBody @Valid EmailDTO emailDTO){
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDTO,emailModel);
        BuyerEmailModel buyerEmail = emailService.sendEmailToBuyer(emailModel, "registration");
        return new ResponseEntity<>(buyerEmail, HttpStatus.CREATED);
    }

    @PostMapping("/seller-action-notify")
    public ResponseEntity<SellerEmailModel> sendingMailToSeller(@RequestBody @Valid EmailDTO emailDTO){
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDTO,emailModel);
        SellerEmailModel sellerEmail = emailService.sendEmailToSeller(emailModel, "sell");
        return new ResponseEntity<>(sellerEmail, HttpStatus.CREATED);
    }

    @PostMapping("/seller-registration-notify")
    public ResponseEntity<SellerEmailModel> notifySellerRegistration(@RequestBody @Valid EmailDTO emailDTO) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDTO, emailModel);
        SellerEmailModel sellerEmail = emailService.sendEmailToSeller(emailModel, "registration");
        return new ResponseEntity<>(sellerEmail, HttpStatus.CREATED);
    }



}
