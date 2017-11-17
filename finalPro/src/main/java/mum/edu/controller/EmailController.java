package mum.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mum.edu.domain.Email;
import mum.edu.domain.Result;
import mum.edu.service.EmailService;

@Controller
public class EmailController {
	@Autowired EmailService emailService;
	
	@RequestMapping(value = "/sendEmail",produces="application/json",method = RequestMethod.POST)
	public @ResponseBody Result email(@RequestBody Email email){
		Result result = new Result();
		
		SimpleMailMessage temp = new SimpleMailMessage();
		temp.setTo(email.getEmailaddress());
		temp.setSubject(email.getSubject());
		temp.setText(email.getContent());
		emailService.sendEmail(temp);
		result.setCode("1");
		result.setDesc("sent successful");
		return result;
	}

}
