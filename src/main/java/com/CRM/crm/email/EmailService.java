package com.CRM.crm.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class EmailService {
    JavaMailSender javaMailSender;

    public EmailService() {
        this.getJavaMailSender();
    }


    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setUsername("******");
        mailSender.setPassword("*******");
        mailSender.setPort(587);

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        return mailSender;
    }

    public void sendActivationEmail(String email, String activationToken) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("*******");
        message.setTo(email);
        message.setSubject("Account Activation");
        message.setText("http://localhost:8080/usersave?token=" + activationToken);
        this.javaMailSender.send(message);
    }
    //For Ethernal mail
    /*
    private void sendActivationEmail(User user) {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("abdullahaydgn0@gmail.com");
        message.setTo(user.getUserEmail());
        message.setSubject("Account Activation");
        message.setText("http//localhost:8080/usersave "+user.getActivationToken());
        getJavaMailSender().send(message);
    }
    public JavaMailSender getJavaMailSender(){
        JavaMailSenderImpl mailSender=new JavaMailSenderImpl();
        mailSender.setHost("\tsmtp.ethereal.email");
        mailSender.setUsername("albert0@ethereal.email");
        mailSender.setPassword("znBm1N4ZBnAz3ZmR67");
        mailSender.setPort(587);
        Properties properties=mailSender.getJavaMailProperties();
        properties.put("mail.smtp.starttls.enable","true");
        return mailSender;
    }
*/
}