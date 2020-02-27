package com.udemy.location.utilities.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.udemy.location.utilities.EmailUtility;

@Component
public class EmailUtilityImpl implements EmailUtility {
	
	@Autowired
	private JavaMailSender sender;

	@Override
	public void sendEmail(String toAddress, String subject, String body) {
       
		MimeMessage mimeMessage = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		
		try {
			helper.setTo(toAddress);
			helper.setSubject(subject);
			helper.setText(body);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sender.send(mimeMessage);
	}

}
