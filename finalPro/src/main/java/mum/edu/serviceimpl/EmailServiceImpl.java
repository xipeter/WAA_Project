package mum.edu.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import mum.edu.domain.Email;
import mum.edu.repository.EmailRepsitory;
import mum.edu.service.EmailService;
@Service
public class EmailServiceImpl implements EmailService {
	@Autowired
	JavaMailSender sender;
	@Autowired
	EmailRepsitory emailRepository;
	@Override
	public void sendEmail(SimpleMailMessage email) {
		// TODO Auto-generated method stub
		sender.send(email);
	}
	@Override
	public Email save(Email email) {
		// TODO Auto-generated method stub
		return this.emailRepository.save(email);
	}
	

}
