package ch.swiggels.weddingApp.services;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer {

	public void send(String recipient, String title, String msg) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("realswiggels@gmail.com", "Sarahheinz2");
			}
		});
		session.setDebug(false);

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("wirHeiraten@gmail.com", "SarahUndDaniel"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
			message.setSubject(title);
			message.setText(msg);
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}