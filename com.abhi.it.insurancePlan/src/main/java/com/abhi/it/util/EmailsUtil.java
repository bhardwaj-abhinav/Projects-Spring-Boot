package com.abhi.it.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailsUtil {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendMail(String subject, String body, String to, File f) throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setSubject(subject);
		helper.setText(body, true);
		helper.setTo(to);
		helper.addAttachment("Plan-Info", f);
		
		mailSender.send(mimeMessage);
		
		return true;
	}
}
