package com.example.demo.utils;

import com.example.demo.models.BuyerEmailModel;
import com.example.demo.models.EmailModel;
import com.example.demo.models.SellerEmailModel;

public class EmailUtils {

    public static BuyerEmailModel createBuyerEmailModel(String flag){
        if(flag == "registration"){
            BuyerEmailModel buyerEmailModel = new BuyerEmailModel();
            //EmailModel emailModel = new EmailModel();
            buyerEmailModel.setEmailFrom("melifrescosemail@gmail.com");
            buyerEmailModel.setSubject("Sua conta foi criada!  \uD83E\uDD73");
            buyerEmailModel.setText("Recebemos o seu cadastro e já está tudo pronto para que possa explorar o nosso catálogo de produtos selecionados!" +
                    "\n Nossa equipe está a disposição para ajudá-lo no que for preciso!" +
                    "\n Trabalhamos intensamente para que sua jornada conosco seja a melhor possível!" +
                    "\n" +
                    "\n" +
                    "Att.\n" +
                    "Equipe MeliFrescos");
//        buyerEmailModel.setEmailModel(emailModel);
            return buyerEmailModel;
        }
        else if(flag == "buy"){

        BuyerEmailModel buyerEmailModel = new BuyerEmailModel();
        //EmailModel emailModel = new EmailModel();
        buyerEmailModel.setEmailFrom("melifrescosemail@gmail.com");
        buyerEmailModel.setSubject("Sua compra foi realizada no MercadoFrescos! ❤️ ");
        buyerEmailModel.setText("Agradecemos pela preferência!\n " +
                "Estamos separando o seu pedido com os produtos mais frescos que temos, e logo tudo estará pronto para ser entregue!" +
                "Só não se espante. Nossa entrega é tão rápida que parece que colhemos tudo no mesmo dia \uD83D\uDE09" +
                "\n" +
                "\n" +
                "Att." +
                "Equipe MeliFrescos");
//        buyerEmailModel.setEmailModel(emailModel);
        return buyerEmailModel;
        }
        return null;
    }


    public static SellerEmailModel createSellerEmailModel(String flag){
        if(flag=="sell"){
            SellerEmailModel sellerEmailModel = new SellerEmailModel();
            //EmailModel emailModel = new EmailModel();
            sellerEmailModel.setEmailFrom("melifrescosemail@gmail.com");
            sellerEmailModel.setSubject("Voce realizou mais uma venda! \uD83C\uDFC6");
            sellerEmailModel.setText("Parabéns pela venda! Pode ficar tranquilo que agora nós cuidaremos de tudo por aqui!");
//        sellerEmailModel.setEmailModel(emailModel);
            return sellerEmailModel;
        }
        else if(flag=="registration"){
            SellerEmailModel sellerEmailModel = new SellerEmailModel();
            //EmailModel emailModel = new EmailModel();
            sellerEmailModel.setEmailFrom("melifrescosemail@gmail.com");
            sellerEmailModel.setSubject("Agora você é o nosso mais novo parceiro! \uD83E\uDD1D");
            sellerEmailModel.setText("Ficamos muito felizes com a sua escolha e estamos muito animados em saber que você será o nosso parceiro nessa jornada!" +
                    "\n" +
                    "\n" +
                    "Att." +
                    "Equipe MeliFrescos");
//        sellerEmailModel.setEmailModel(emailModel);
            return sellerEmailModel;
        }
        return null;
    }



}
