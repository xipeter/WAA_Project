package mum.edu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.edu.domain.Email;
import mum.edu.domain.EmailHistory;
import mum.edu.domain.Restaurant;
import mum.edu.domain.Result;
import mum.edu.service.EmailService;
import mum.edu.service.RestaurantService;

@Controller
public class EmailController {
	@Autowired EmailService emailService;
	@Autowired RestaurantService restaurantService;
	
	@RequestMapping(value = "/sendEmail",produces="application/json",method = RequestMethod.POST)
	public @ResponseBody Result email(@RequestBody Email email){
		Result result = new Result();
		
		SimpleMailMessage temp = new SimpleMailMessage();
		List<EmailHistory> historys = email.getHistorys();
		for(int i =0;i<historys.size();i++) {
			temp.setTo(historys.get(i).getEmail());
			temp.setSubject(email.getSubject());
			temp.setText(email.getContent());
			emailService.sendEmail(temp);
		}
		
		result.setCode("1");
		result.setDesc("sent successful");
		return result;
	}
	@RequestMapping(value="/sendmailForm",method = RequestMethod.GET)
	public String getemail(@ModelAttribute("emailobj") Email email,Model model) {
		List<Restaurant> restaurants =  restaurantService.findAll();
		model.addAttribute("restaurants", restaurants);
		return "email";
	}
	@RequestMapping(value="/sendmailForm",method = RequestMethod.POST)
	public String postemail(@Valid @ModelAttribute("emailobj") Email email,BindingResult bingResult,RedirectAttributes redirect) {
		System.out.print(email.getHistorys().size()+" "+email.getSubject()+"  "+email.getContent());
		if(bingResult.hasErrors()) {
			return "email";
		}
		return "email";
	}

}
