package com.example.warehouse_v3.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;

    public void sendMail(String toEmail,
                         String body,
                         String subject) throws MessagingException {
        String image = "<br><img src='D:/FullStack_Backend/Warehouse_v3/src/main/resources/templates/busines.jpg'/><br><b>Best Regards</b>";
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message,true);
        mimeMessageHelper.setFrom("devuzcoder@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        FileSystemResource file = new FileSystemResource(new File("D:/FullStack_Backend/Warehouse_v3/src/main/resources/templates/post2.jpg"));
        mimeMessageHelper.addAttachment("post2.jpg", file);
        mimeMessageHelper.setText(body + image,true);
        mimeMessageHelper.setSubject(subject);
        javaMailSender.send(message);
    }
}
