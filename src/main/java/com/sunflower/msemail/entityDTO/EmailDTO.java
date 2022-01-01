package com.sunflower.msemail.entityDTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.sunflower.msemail.entity.EmailModel;

public class EmailDTO {

	@NotBlank
	private String ownerRef;

	@NotBlank
	@Email
	private String emailFrom;

	@NotBlank
	@Email
	private String emailTo;

	@NotBlank
	private String subject;

	@NotBlank
	private String text;

	public EmailDTO() {

	}

	public EmailDTO(EmailModel entity) {

		this.ownerRef = entity.getOwnerRef();
		this.emailFrom = entity.getEmailFrom();
		this.emailTo = entity.getEmailTo();
		this.subject = entity.getSubject();
		this.text = entity.getText();
	}

	public String getOwnerRef() {
		return ownerRef;
	}

	public void setOwnerRef(String ownerRef) {
		this.ownerRef = ownerRef;
	}

	public String getEmailFrom() {
		return emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
