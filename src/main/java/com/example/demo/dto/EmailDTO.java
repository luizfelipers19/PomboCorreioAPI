package com.example.demo.dto;


import lombok.Data;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class EmailDTO {

    //final String SENDEREMAIL = "melifrescosemail@gmail.com";

    @NotBlank
    private String ownerRef;
    @NotBlank
    @Email
    private String emailTo;


}
