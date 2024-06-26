package com.riwi.localstorage.riwi_local_storage.infrastructure.helpers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
@Component
@AllArgsConstructor
public class EmailHelpper {

    private final JavaMailSender mailSender;

    private String readHTMLTemplate(String emailPathUrl,String description, String title, String name, String date ){
        final Path path = Paths.get(emailPathUrl);

        try (var lines = Files.lines(path)){
            var html = lines.collect(Collectors.joining());

            return html.replace("{description}", description)
                    .replace("{title}", title)
                    .replace("{date}", date)
                    .replace("{name}", name);
        } catch (IOException e) {
            System.out.println("File could not be read "+e.getMessage());
            throw new RuntimeException();
        }
    }



    public void sendEmail(String destiny, String description, String title,String name, LocalDateTime date, String emailPathUrl){
        MimeMessage message = mailSender.createMimeMessage();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String dateAppointment = date.format(formatter);
        String htmlContent = this.readHTMLTemplate(description, title, name,dateAppointment,emailPathUrl);

        try {
            // change this email for the credentials
            message.setFrom(new InternetAddress("email@dominio.com"));
            message.setSubject("Hey!, read that email!");

            message.setRecipients(MimeMessage.RecipientType.TO,destiny);
            message.setContent(htmlContent, MediaType.TEXT_HTML_VALUE);

            mailSender.send(message);
            System.out.println("Email sent");

        } catch (Exception e) {
            System.out.println("ERROR. Could not send the email " + e.getMessage());

        }
    }
}