package com.example.demo.config;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import java.util.Properties;

@Configuration
public class EmailConfiguration {
    @Value("${spring.mail.username}")
    private String emailUsername;

    @Value("${spring.mail.password}")
    private String emailPassword;

    // we send the mail from spring to User inbox using java mail sender
    @Bean
    public JavaMailSender javaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");    // using STMP ( simple mail transfer protocol ) to send mail using gmail\
        mailSender.setPort(587);
        mailSender.setUsername(emailUsername);
        mailSender.setPassword(emailPassword);

        // setup properties for mailSender
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp"); // connect to mail server (gmail) using stmp protocol
        props.put("mail.smtp.auth", "true");    // require authentication
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");    // enable debug mode

        return mailSender;
    }

}
