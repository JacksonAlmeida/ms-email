package com.sunflower.msemail.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sunflower.msemail.entity.EmailModel;
import com.sunflower.msemail.enums.StatusEmail;
import com.sunflower.msemail.repository.EmailRepository;

@Service
public class EmailService {

	@Autowired
	private EmailRepository emailRepository;

	@Autowired
	private JavaMailSender javaMEilSender;

	public EmailModel getSendDataEmail(EmailModel email) {
		email.setSendDataEmail(Instant.now());
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(email.getEmailFrom());
			message.setTo(email.getEmailTo());
			message.setSubject(email.getSubject());
			message.setText(email.getText());
			javaMEilSender.send(message);
			email.setStatusEmail(StatusEmail.Send);
		} catch (MailException e) {
			email.setStatusEmail(StatusEmail.Error);
		} finally {
			return emailRepository.save(email);
		}
	}
}
