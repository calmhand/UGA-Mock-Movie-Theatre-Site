package com.se.onlinemoviebooking.application.services;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {

	private final String appEmail;
	private final String appPassword;
	private Properties props;
	private Session session;

	private static EmailService emailService = null;

	// let this be singleton for now
	public static EmailService getInstance() {
		if (emailService == null) {
			try {
				emailService = new EmailService();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return emailService;
	}

	public EmailService() {
		appEmail = "b3onlinemoviebooking@outlook.com";
		appPassword = "Teamb3@uga";
		props = new Properties();
		props.put("mail.smtp.host", "smtp-mail.outlook.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");

		session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(appEmail, appPassword);
			}
		});

	}

	public void sendEmail(String sub, String body, String emailTo) {
		try {

			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(appEmail, "b3onlinemoviebooking"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo, "User"));
			msg.setSubject(sub);
			msg.setText(body);
			Transport.send(msg);
			System.out.println("Email sent successfully...");
		} catch (AddressException e) {
			System.out.println("exception");
		} catch (MessagingException e) {
			System.out.println("exception");
		} catch (UnsupportedEncodingException e) {
			System.out.println("exception");
		}
	}

}
