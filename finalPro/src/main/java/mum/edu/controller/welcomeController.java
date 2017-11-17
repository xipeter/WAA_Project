package mum.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class welcomeController {

	@Autowired
	JavaMailSender sender;
	
	@RequestMapping(value="/")
	public String home() {
		return "index";
	}
	@RequestMapping(value="/home")
	public String homeIndex() {
		return "home";
	}
	@RequestMapping(value="/test")
	public String email() {
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo("xizongfei@gmail.com");
		email.setSubject("Hello World");
		email.setText("this is a email from mum");
		sender.send(email);
		return "home";
	}
}
