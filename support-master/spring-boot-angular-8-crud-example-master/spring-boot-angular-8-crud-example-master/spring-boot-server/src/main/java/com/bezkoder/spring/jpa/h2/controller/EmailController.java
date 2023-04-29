package com.bezkoder.spring.jpa.h2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;

//import com.bezkoder.spring.jpa.h2.model.EmailRequest;
import com.bezkoder.spring.jpa.h2.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.websocket.server.PathParam;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    EmailService emailService;
    @Autowired
    private JavaMailSender javaMailSender;
    /*
    @GetMapping("/sendEmail")
    public String sendEmail() {
        return emailService.sendEmail();
    }

    @GetMapping("/sendEmailwithAttachment")
    public String sendEmailwithAttachment() {
        return emailService.sendEmailwithAttachment();
    }

    @PostMapping("/sendEmail")
    public void csendEmail(@RequestBody EmailRequest emailRequest) throws MessagingException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailRequest.getEmail());
        message.setTo("siiheb64@gmail.com"); // Replace with your email address
        message.setSubject("New contact from " + emailRequest.getName());
        message.setText(emailRequest.getDescription());
        javaMailSender.send(message);
    }
    */
/*
    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(@RequestParam String name, @RequestParam String email, @RequestParam String description) {
        try {
            emailService.sendEmail(name, email, description);
            return ResponseEntity.ok("Email sent successfully!");
        } catch (MessagingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending email: " + e.getMessage());
        }
    }

 */
    /*
@PostMapping("/send-email")
@ResponseBody
public ResponseEntity<String> sendEmail( String to, String text, String subject) {
    Email email = emailService.;
    String text = "A new event has been created with the following details:\n\n" +
            "Name: " + event.getNomEvent() + "\n" +
            "Date: " + event.getDateDebutEvent() + "\n" +
            "Location: " + event.getRegionEvent() + "\n" +
            "Description: " + event.getDescriptionEvent() + "\n";
    String subject = "New Event";
    for (String to: recipients) {
        eventService.sendMail(to, subject, text);
    }

        emailService.sendEmail(to, subject, text);

    return ResponseEntity.ok("Email sent successfully!");
}

     */
    @PostMapping( "/sendemail")
    public String sendEmail() throws AddressException, MessagingException, IOException {
        emailService .sendEmail();
        //	sendingEmailApplication.sendEmailWithAttachment();
        return "Email sent successfully";
    }
    @PostMapping( "/sendemailwithAtt")
    public String sendEmailwithAtt() throws AddressException, MessagingException, IOException {
       // emailService .sendEmail();
        emailService.sendEmailWithAttachment();
        return "Email sent successfully";
    }
}
