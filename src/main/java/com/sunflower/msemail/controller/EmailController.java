package com.sunflower.msemail.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunflower.msemail.entity.EmailModel;
import com.sunflower.msemail.entityDTO.EmailDTO;
import com.sunflower.msemail.service.EmailService;

@RestController
@RequestMapping(value = "/home")
public class EmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping(value = "/sending-email")
	public ResponseEntity<EmailModel> sendEmail(@RequestBody @Valid EmailDTO emailDto) {
		EmailModel email = new EmailModel();
		BeanUtils.copyProperties(emailDto, email);
		emailService.getSendDataEmail(email);
		return new ResponseEntity<>(email, HttpStatus.CREATED);
	}
}
