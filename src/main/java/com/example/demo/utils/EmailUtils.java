package com.example.demo.utils;

import com.example.demo.models.BuyerEmailModel;
import com.example.demo.models.EmailModel;
import com.example.demo.models.SellerEmailModel;

public class EmailUtils {

    public static BuyerEmailModel createBuyerEmailModel(){
        BuyerEmailModel buyerEmailModel = new BuyerEmailModel();
        //EmailModel emailModel = new EmailModel();
        buyerEmailModel.setEmailFrom("melifrescosemail@gmail.com");
        buyerEmailModel.setSubject("Sua compra foi realizada no MercadoFrescos");
        buyerEmailModel.setText("Agradecemos pela preferência! Estamos separando o seu pedido com os produtos mais frescos que temos, e logo estará na sua porta!");
//        buyerEmailModel.setEmailModel(emailModel);
        return buyerEmailModel;
    }

    public static SellerEmailModel createSellerEmailModel(){
        SellerEmailModel sellerEmailModel = new SellerEmailModel();
        //EmailModel emailModel = new EmailModel();
        sellerEmailModel.setEmailFrom("melifrescosemail@gmail.com");
        sellerEmailModel.setSubject("Voce realizou mais uma venda!");
        sellerEmailModel.setText("Parabéns pela venda! Pode ficar tranquilo que agora nós cuidamos de tudo por aqui!");
//        sellerEmailModel.setEmailModel(emailModel);
        return sellerEmailModel;
    }
}
