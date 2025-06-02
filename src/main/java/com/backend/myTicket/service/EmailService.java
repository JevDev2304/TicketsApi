package com.backend.myTicket.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;
    private static final String QR_API_BASE_URL = "https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=";
    @Value("${spring.mail.username}")
    private String senderEmail;
    /**
     * Sends an HTML email with event details and a QR code (from an external API).
     *
     * @param to              Recipient's email address.
     * @param eventName       Name of the event (for the subject).
     * @param eventImage     Name of the event (for the subject).
     * @param eventLocation   Location of the event.
     * @param eventCategory   Category of the event.
     * @param eventHost       Host of the event.
     * @param eventDate       Date of the event.
     * @param ticketTypeName  Name of the ticket type.
     * @param ticketPrice     Price of the ticket.
     * @param purchaseDate    Date of purchase.
     * @param uuid            UUID for the QR code.
     * @throws MessagingException           If there's an issue with email sending.
     * @throws UnsupportedEncodingException If there's an issue encoding the UUID.
     */

    public void sendHtmlEmailWithEventDetails(
            String to,
            String eventName,
            String eventLocation,
            String eventCategory,
            String eventHost,
            String eventDate,
            String ticketTypeName,
            int ticketPrice,
            String purchaseDate,
            String uuid,
            String eventImage,
            String userName
    ) throws MessagingException, UnsupportedEncodingException {

        String encodedUuid = URLEncoder.encode(uuid, "UTF-8");
        String qrImageUrl = QR_API_BASE_URL + encodedUuid;
        String htmlContent = generateHtmlContent(eventName, eventLocation, eventCategory, eventHost, eventDate, ticketTypeName, ticketPrice, purchaseDate, qrImageUrl, eventImage, userName);

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom(senderEmail);

        helper.setTo(to);
        helper.setSubject("Your Tickets for " + eventName); // Dynamic subject
        helper.setText(htmlContent, true);

        mailSender.send(message);
        System.out.println("Email with event details and QR sent to: " + to);
    }

    private String generateHtmlContent(
            String eventName,
            String eventLocation,
            String eventCategory,
            String eventHost,
            String eventDate,
            String ticketTypeName,
            int ticketPrice,
            String purchaseDate,
            String qrImageUrl,
            String eventImage,
            String userName
    ) {
        return "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<style>" +
                "@import url('https://fonts.googleapis.com/css2?family=DM+Sans:wght@400;700&display=swap');" +

                "body { " +
                "  font-family: 'DM Sans', Arial, sans-serif; " +
                "  margin: 0; " +
                "  background-color: #f4f4f8; " +
                "  color: #333; " +
                "  padding: 40px 20px; " +
                "}" +

                ".container { " +
                "  background-color: #fff; " +
                "  max-width: 600px; " +
                "  margin: 0 auto; " +
                "  padding: 30px; " +
                "  border-radius: 12px; " +
                "  border: 1px solid #ddd; " +
                "  box-shadow: 0 8px 24px rgba(0, 0, 0, 0.08); " +
                "}" +

                "h2 { " +
                "  color: #802EF8; " +
                "  text-align: center; " +
                "  margin-bottom: 20px; " +
                "}" +

                ".event-image { " +
                "  text-align: center; " +
                "  margin-bottom: 25px; " +
                "}" +

                ".event-image img { " +
                "  max-width: 100%; " +
                "  height: auto; " +
                "  border-radius: 10px; " +
                "  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.08); " +
                "}" +

                "p { " +
                "  color: #555; " +
                "  line-height: 1.6; " +
                "  margin: 10px 0; " +
                "}" +

                "ul { " +
                "  list-style: none; " +
                "  padding: 0; " +
                "  margin: 20px 0; " +
                "}" +

                "ul li { " +
                "  margin-bottom: 10px; " +
                "  padding: 10px; " +
                "  background-color: #f9f9ff; " +
                "  border-left: 4px solid #802EF8; " +
                "  border-radius: 4px; " +
                "}" +

                "ul li strong { " +
                "  color: #802EF8; " +
                "}" +

                ".qr-container { " +
                "  text-align: center; " +
                "  margin-top: 30px; " +
                "}" +

                ".qr-container img { " +
                "  border: 1px solid #eee; " +
                "  padding: 10px; " +
                "  background-color: white; " +
                "  max-width: 160px; " +
                "  border-radius: 8px; " +
                "  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.06); " +
                "}" +

                ".footer { " +
                "  text-align: center; " +
                "  margin-top: 30px; " +
                "  font-size: 0.95rem; " +
                "  color: #666; " +
                "}" +

                "</style>" +
                "</head>" +
                "<body>" +
                "<div class='container'>" +
                "<h2>Your Tickets for " + eventName + "</h2>" +

                "<div class='event-image'>" +
                "<img src='" + eventImage + "' alt='Event Image' />" +
                "</div>" +

                "<p>Dear " + userName + ",</p>" +
                "<p>Thank you for your purchase. Here are your ticket details:</p>" +

                "<ul>" +
                "<li><strong>Event:</strong> " + eventName + "</li>" +
                "<li><strong>Location:</strong> " + eventLocation + "</li>" +
                "<li><strong>Category:</strong> " + eventCategory + "</li>" +
                "<li><strong>Host:</strong> " + eventHost + "</li>" +
                "<li><strong>Date:</strong> " + eventDate + "</li>" +
                "<li><strong>Ticket Type:</strong> " + ticketTypeName + "</li>" +
                "<li><strong>Price:</strong> $" + ticketPrice + "</li>" +
                "<li><strong>Purchase Date:</strong> " + purchaseDate + "</li>" +
                "</ul>" +

                "<div class='qr-container'>" +
                "<p><strong>Please scan the QR code below for entry:</strong></p>" +
                "<img src='" + qrImageUrl + "' alt='QR Code' />" +
                "</div>" +

                "<div class='footer'>" +
                "<p>We look forward to seeing you at the event!</p>" +
                "<p>Sincerely,<br>Your Ticketing Team 💜</p>" +
                "</div>" +

                "</div>" +
                "</body>" +
                "</html>";
    }



}
