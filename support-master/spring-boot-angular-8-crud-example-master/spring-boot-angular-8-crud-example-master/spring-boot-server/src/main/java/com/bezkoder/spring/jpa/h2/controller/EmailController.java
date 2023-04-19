package com.bezkoder.spring.jpa.h2.controller;



import com.bezkoder.spring.jpa.h2.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    EmailService emailService;

    @GetMapping("/sendEmail")
    public String sendEmail() {
        return emailService.sendEmail();
    }

    @GetMapping("/sendEmailwithAttachment")
    public String sendEmailwithAttachment() {
        return emailService.sendEmailwithAttachment();
    }

}
