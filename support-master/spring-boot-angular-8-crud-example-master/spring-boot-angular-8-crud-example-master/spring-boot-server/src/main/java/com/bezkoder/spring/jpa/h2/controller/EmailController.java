package com.bezkoder.spring.jpa.h2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.bezkoder.spring.jpa.h2.model.EmailRequest;
import com.bezkoder.spring.jpa.h2.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    EmailService emailService;
    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping("/sendEmail")
    public String sendEmail() {
        return emailService.sendEmail();
    }

    @GetMapping("/sendEmailwithAttachment")
    public String sendEmailwithAttachment() {
        return emailService.sendEmailwithAttachment();
    }

  /*  @PostMapping("/sendEmail")
    public void csendEmail(@RequestBody EmailRequest emailRequest) throws MessagingException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailRequest.getEmail());
        message.setTo("siiheb64@gmail.com"); // Replace with your email address
        message.setSubject("New contact from " + emailRequest.getName());
        message.setText(emailRequest.getDescription());
        javaMailSender.send(message);
    }
    */

    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(@RequestParam String name, @RequestParam String email, @RequestParam String description) {
        try {
            emailService.sendEmail(name, email, description);
            return ResponseEntity.ok("Email sent successfully!");
        } catch (MessagingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending email: " + e.getMessage());
        }
    }
}

