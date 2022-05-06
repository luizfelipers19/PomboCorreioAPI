package com.example.demo.integration;


import com.example.demo.dto.EmailDTO;
import com.example.demo.models.BuyerEmailModel;
import com.example.demo.services.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmailSenderIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    private EmailService service;

    private final String BASE_URL = "http://localhost:8082/";
    private final String BUYERREGISTRATIONENDPOINT = "buyer-registration-notify";
//    private final String BUYACTIONENDPOINT = "/buyer-registration-notify";
//    private final String BUYERREGISTRATIONENDPOINT = "/buyer-registration-notify";
//    private final String BUYERREGISTRATIONENDPOINT = "/buyer-registration-notify";

    @Test
    public void testPOSTCreateBuyer() throws Exception {

        EmailDTO ereq = new EmailDTO();
        ereq.setName("Luiz Felipe");
        ereq.setOwnerRef("1");
        ereq.setEmailTo("luizfelipers19@gmail.com");


        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();

        String payloadRequest = writer.writeValueAsString(ereq);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(BASE_URL + BUYERREGISTRATIONENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadRequest))
                .andDo(print()).andExpect(status().isCreated()).andReturn();


        String jsonObjectReturned = mvcResult.getResponse().getContentAsString();
        BuyerEmailModel eres = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .readValue(jsonObjectReturned, BuyerEmailModel.class);

        assertEquals("Luiz Felipe", eres.getName());
    }




}
