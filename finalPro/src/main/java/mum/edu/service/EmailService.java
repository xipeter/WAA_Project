package mum.edu.service;

import org.springframework.mail.SimpleMailMessage;

import mum.edu.domain.Email;

public interface EmailService {
	public void sendEmail(SimpleMailMessage email);
	public Email save(Email email);
}
