package com.bezkoder.spring.jpa.h2.service;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    private JavaMailSender mailSender;

    /*  public String sendEmail() {
          SimpleMailMessage message = new SimpleMailMessage();

          message.setFrom("siiheb64@gmail.com");
          message.setTo("siiheb64@gmail.com");
          message.setSubject("Test ");
          message.setText("Test ");

          javaMailSender.send(message);

          return "Mail sent successfully";
      }

      public String sendEmailwithAttachment() {
          try {
              MimeMessage message = javaMailSender.createMimeMessage();

              MimeMessageHelper messageHelper =
                      new MimeMessageHelper(message, true);

              messageHelper.setFrom("siiheb64@gmail.com");
              messageHelper.setTo("siiheb64@gmail.com");
              messageHelper.setSubject("Test ");
              messageHelper.setText("test ");

              File file = new File("");

              messageHelper.addAttachment(file.getName(), file);

              javaMailSender.send(message);

              return "Mail sent successfully";

          } catch (Exception e) {
              return "Mail sent failed";
          }
      }

     /* public void csendEmail(String to, String subject, String text) {
          SimpleMailMessage message = new SimpleMailMessage();
          message.setTo(to);
          message.setSubject(subject);
          message.setText(text);
          mailSender.send(message);
      }

      */
/*
    public void sendEmail(String name, String email, String description) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom(email);
        helper.setTo("siiheb64@gmail.com");
        helper.setSubject("New Message from " + name);
        helper.setText(description);

        javaMailSender.send(message);
    }


    //@Override
    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);

    }
     */
    public void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("mohamediheb.lahzami@esprit.tn");
        // msg.setTo("siiheb64@gmail.com");
        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);

    }

    public void sendEmailWithAttachment() throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);

        helper.setTo("email address to whom you send the mail");

        helper.setSubject("Testing from Spring Boot");

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        helper.setText("<h1>Check attachment for image!</h1>", true);

        // hard coded a file path
        FileSystemResource file = new FileSystemResource(new File("C:/Users\\1302143\\Desktop\\ssl4.png"));

        helper.addAttachment("ssl4.png", file);

        javaMailSender.send(msg);

    }
}
