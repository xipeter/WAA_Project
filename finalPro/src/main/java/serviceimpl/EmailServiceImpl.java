package mum.edu.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import mum.edu.service.EmailService;
@Service
public class EmailServiceImpl implements EmailService {
	@Autowired
	JavaMailSender sender;
	
	@Override
	public void sendEmail(SimpleMailMessage email) {
		// TODO Auto-generated method stub
		sender.send(email);
	}

}
