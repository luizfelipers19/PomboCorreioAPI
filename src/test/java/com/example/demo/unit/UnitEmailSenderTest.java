package com.example.demo.unit;

import com.example.demo.models.BuyerEmailModel;
import com.example.demo.models.EmailModel;
import com.example.demo.models.SellerEmailModel;
import com.example.demo.repositories.IBuyerEmailRepository;
import com.example.demo.repositories.ISellerEmailRepository;
import com.example.demo.services.EmailService;
import com.example.demo.utils.EmailUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UnitEmailSenderTest {

    @Mock
    private static IBuyerEmailRepository buyerEmailRepository;

    @Mock
    private static ISellerEmailRepository sellerEmailRepository;

    @InjectMocks
    private static EmailService emailService;

    public BuyerEmailModel setupBuyerEmailModel(){

        BuyerEmailModel buyerEmailModel = EmailUtils.createBuyerEmailModel("registration");
        buyerEmailModel.setEmailTo("luizfelipers19@gmail.com");
        buyerEmailModel.setName("Luiz Felipe");
        buyerEmailModel.setOwnerRef("1");
        Mockito.when(buyerEmailRepository.save(Mockito.any())).thenReturn(buyerEmailModel);

        return buyerEmailModel;
    }



    public SellerEmailModel setupSellerEmailModel(){

        SellerEmailModel sellerEmailModel = EmailUtils.createSellerEmailModel("registration");
        sellerEmailModel.setEmailTo("luizfelipers19@gmail.com");
        sellerEmailModel.setName("Luiz Felipe");
        sellerEmailModel.setOwnerRef("1");




        Mockito.when(sellerEmailRepository.save(Mockito.any())).thenReturn(sellerEmailModel);

        return sellerEmailModel;
    }

    @Test
    public void mustSendEmailToBuyerAtRegistration(){
        this.setupBuyerEmailModel();

        EmailModel emailModel = new EmailModel();
        emailModel.setOwnerRef("1");
        emailModel.setName("Luiz Felipe");
        emailModel.setEmailTo("luizfelipers19@gmail.com");

        BuyerEmailModel buyer = emailService.sendEmailToBuyer(emailModel, "registration");
        Assertions.assertEquals("luizfelipers19@gmail.com", buyer.getEmailTo());

    }

    @Test
    public void mustSendEmailToSellerAtRegistration(){
        this.setupSellerEmailModel();

        EmailModel emailModel = new EmailModel();
        emailModel.setOwnerRef("1");
        emailModel.setName("Luiz Felipe");
        emailModel.setEmailTo("luizfelipers19@gmail.com");

        SellerEmailModel seller = emailService.sendEmailToSeller(emailModel, "registration");
        Assertions.assertEquals("luizfelipers19@gmail.com", seller.getEmailTo());

    }











}
