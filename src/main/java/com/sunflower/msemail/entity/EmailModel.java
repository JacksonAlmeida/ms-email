package com.sunflower.msemail.entity;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sunflower.msemail.enums.StatusEmail;

@Entity
@Table(name = "tb_email")
public class EmailModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String ownerRef;
	private String emailFrom;
	private String emailTo;
	private String subject;

	@Column(columnDefinition = "TEXT")
	private String text;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant sendDataEmail;

	private Integer statusEmail;

	public EmailModel() {

	}

	public EmailModel(Long id, String ownerRef, String emailFrom, String emailTo, String subject, String text,
			Instant sendDataEmail, StatusEmail statusEmail) {

		this.id = id;
		this.ownerRef = ownerRef;
		this.emailFrom = emailFrom;
		this.emailTo = emailTo;
		this.subject = subject;
		this.text = text;
		this.sendDataEmail = sendDataEmail;
		setStatusEmail(statusEmail);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Instant getSendDataEmail() {
		return sendDataEmail;
	}

	public void setSendDataEmail(Instant sendDataEmail) {
		this.sendDataEmail = sendDataEmail;
	}

	public StatusEmail getStatusEmail() {
		return StatusEmail.valueOf(statusEmail);
	}

	public void setStatusEmail(StatusEmail statusEmail) {
		if (statusEmail != null)
			this.statusEmail = statusEmail.getCode();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmailModel other = (EmailModel) obj;
		return Objects.equals(id, other.id);
	}
}
