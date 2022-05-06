package com.example.demo.models;


import com.example.demo.enums.StatusEmail;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
//@Builder
@AllArgsConstructor
@Entity
public class EmailModel implements Serializable{



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long emailId;
    private String ownerRef;
    private String name;
    private String emailFrom;
    private String emailTo;
    private String subject;
    //@Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;

}
