package com.riwi.localstorage.riwi_local_storage.infrastructure.helpers;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AlertsService {

    private final JavaMailSender mailSender;

    public void sendMailStock(String destinaty, String brand, List<String> productNames, List<String> categories, List<String> suppliers, List<Integer> currentQuantities) {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        String htmlContent = this.readHTMLTemplateStock(brand, productNames, categories, suppliers, currentQuantities);
        String transmitter = "";

        try {
            mimeMessage.setFrom(new InternetAddress(transmitter));
            mimeMessage.setSubject("Product Low Stock");
            mimeMessage.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(destinaty));
            mimeMessage.setContent(htmlContent, "text/html");

            mailSender.send(mimeMessage);
            System.out.println("Email sent");

        } catch (Exception e) {
            System.out.println("Email send error: " + e.getMessage());

        }
    }

    String readHTMLTemplateStock(String brand, List<String> productNames, List<String> categories, List<String> suppliers, List<Integer> currentQuantities) {
        final Path path = Paths.get("src/main/resources/emailsTemplates/productLowStockAlert.html");

        try (var lines = Files.lines(path)) {
            var html = lines.collect(Collectors.joining());

            html = html.replace("{{brand}}", brand)
                    .replace("{{date}}", LocalDate.now().toString());

            StringBuilder tableRows = new StringBuilder();
            for (int i = 0; i < productNames.size(); i++) {
                tableRows.append("<tr>")
                        .append("<td>").append(productNames.get(i)).append("</td>")
                        .append("<td>").append(categories.get(i)).append("</td>")
                        .append("<td>").append(suppliers.get(i)).append("</td>")
                        .append("<td>").append(currentQuantities.get(i)).append("</td>")
                        .append("</tr>");
            }

            html = html.replace("{{tableRows}}", tableRows.toString());

            return html;

        } catch (IOException e) {
            System.out.println("I can't read the HTML");
            throw new RuntimeException(e);

        } 
    }

    /*
     * ====================email for expiration product ====================
     */

     public void sendMailExpiration(String destinaty, String brand, List<String> productNames, List<String> categories, List<String> suppliers, List<Integer> daysUntilExpiry) {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        String htmlContent = this.readHTMLTemplateExpiration(brand, productNames, categories, suppliers, daysUntilExpiry);
        String transmitter = "";

        try {
            mimeMessage.setFrom(new InternetAddress(transmitter));
            mimeMessage.setSubject("Expiring Products Report");
            mimeMessage.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(destinaty));
            mimeMessage.setContent(htmlContent, "text/html");

            mailSender.send(mimeMessage);
            System.out.println("Email sent");

        } catch (Exception e) {
            System.out.println("Email send error: " + e.getMessage());
        }
    }

    String readHTMLTemplateExpiration(String brand, List<String> productNames, List<String> categories, List<String> suppliers, List<Integer> daysUntilExpiry) {
        final Path path = Paths.get("src/main/resources/emailsTemplates/expiringProductsAlert.html");

        try (var lines = Files.lines(path)) {
            var html = lines.collect(Collectors.joining());

            // Replace header placeholders
            html = html.replace("{{brand}}", brand)
                    .replace("{{REPORT_DATE}}", LocalDate.now().toString());

            // Generate the table rows for each product
            StringBuilder tableRows = new StringBuilder();
            for (int i = 0; i < productNames.size(); i++) {
                tableRows.append("<tr>")
                        .append("<td>").append(productNames.get(i)).append("</td>")
                        .append("<td>").append(categories.get(i)).append("</td>")
                        .append("<td>").append(suppliers.get(i)).append("</td>")
                        .append("<td>").append(daysUntilExpiry.get(i)).append("</td>")
                        .append("</tr>");
            }

            // Replace the table row placeholder with the actual rows
            html = html.replace("{{tableRows}}", tableRows.toString());

            return html;

        } catch (IOException e) {
            System.out.println("I can't read the HTML");
            throw new RuntimeException(e);
        }
    }


}
