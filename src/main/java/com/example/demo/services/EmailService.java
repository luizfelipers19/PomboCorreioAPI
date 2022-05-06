package com.example.demo.services;


import com.example.demo.enums.StatusEmail;
import com.example.demo.models.BuyerEmailModel;
import com.example.demo.models.EmailModel;
import com.example.demo.models.SellerEmailModel;
import com.example.demo.repositories.IBuyerEmailRepository;

import com.example.demo.repositories.ISellerEmailRepository;
import com.example.demo.utils.EmailUtils;
import lombok.AllArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class EmailService {

    @Autowired
    IBuyerEmailRepository buyerEmailRepository;

    @Autowired
    ISellerEmailRepository sellerEmailRepository;

    @Autowired
    private JavaMailSender emailSender;


    public BuyerEmailModel sendEmailToBuyer(EmailModel emailModel, String flag) {

        BuyerEmailModel buyerEmailModel= EmailUtils.createBuyerEmailModel(flag);

        buyerEmailModel.setSendDateEmail(LocalDateTime.now());
        buyerEmailModel.setName(emailModel.getName());
        buyerEmailModel.setEmailTo(emailModel.getEmailTo());
        buyerEmailModel.setOwnerRef(emailModel.getOwnerRef());
        SimpleMailMessage message = new SimpleMailMessage();
        //sender email address
        message.setFrom(buyerEmailModel.getEmailFrom());
        //receives the destination email address from the payload
        message.setTo(emailModel.getEmailTo());
        message.setSubject(buyerEmailModel.getSubject());
        message.setText(buyerEmailModel.getText());

        try{

            emailSender.send(message);
            buyerEmailModel.setStatusEmail(StatusEmail.SENT);
        }
        catch (MailException ex){
            emailModel.setStatusEmail(StatusEmail.ERROR);
        }
        finally {
            return buyerEmailRepository.save(buyerEmailModel);
        }

    }


    public SellerEmailModel sendEmailToSeller(EmailModel emailModel, String flag) {

        SellerEmailModel sellerEmailModel= EmailUtils.createSellerEmailModel(flag);

        sellerEmailModel.setSendDateEmail(LocalDateTime.now());
        sellerEmailModel.setName(emailModel.getName());
        sellerEmailModel.setEmailTo(emailModel.getEmailTo());
        sellerEmailModel.setOwnerRef(emailModel.getOwnerRef());
        SimpleMailMessage message = new SimpleMailMessage();
        //sender email address
        message.setFrom(sellerEmailModel.getEmailFrom());
        //receives the destination email address from the payload
        message.setTo(emailModel.getEmailTo());
        message.setSubject(sellerEmailModel.getSubject());
        message.setText(sellerEmailModel.getText());

        try{

            emailSender.send(message);
            sellerEmailModel.setStatusEmail(StatusEmail.SENT);
        }
        catch (MailException ex){
            emailModel.setStatusEmail(StatusEmail.ERROR);
        }
        finally {
            return sellerEmailRepository.save(sellerEmailModel);
        }

    }




}
