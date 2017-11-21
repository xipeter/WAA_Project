package mum.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mum.edu.domain.EmailHistory;
import mum.edu.domain.Restaurant;
import mum.edu.domain.Result;
import mum.edu.domain.Username;
import mum.edu.service.EmailService;
import mum.edu.service.RestaurantService;
import mum.edu.service.UsernameService;


@Controller
public class ApproveController {
	@Autowired 
	RestaurantService restaurantService;
	@Autowired
	UsernameService usernameService;
	@Autowired
	EmailService emailService;
	@RequestMapping(value="/approve")
	public String approve(Model model) {
		List<Restaurant>  restaurants = restaurantService.findRestaurant();//enabled users
		List<Restaurant>  restaurantsDisabled = restaurantService.findDisabledRestaurant();//disabled users
		model.addAttribute("restaurants", restaurants);
		model.addAttribute("restaurants_disabled", restaurantsDisabled);
		return "approve";
	}
	@RequestMapping(value="/enable",method = RequestMethod.POST,produces="application/json")
	public @ResponseBody Result enable(@RequestBody EmailHistory emailHistory) {
		
		Result result = new Result();
//		System.out.println(id);
		Username user =  usernameService.findByUsername(emailHistory.getEmail());
		user.setEnabled(true);
		usernameService.disableOrEnable(user);
		//get the user detail
		Restaurant resturant = restaurantService.findByUsername(emailHistory.getEmail());
		
		
		//send the email
		
		
		SimpleMailMessage temp = new SimpleMailMessage();
		temp.setTo(resturant.getEmail());
		temp.setSubject("Congratulations-From Taobao System");
		temp.setText("Congratulation,guys,you are here");
		try {
			emailService.sendEmail(temp);
			System.out.println(temp);
		}catch(Exception e){
			System.out.print("send email failed-------------------------------------------"+e.getMessage());
		}
		
		//set the result
		result.setCode("1");
		result.setDesc("successfully");

		return result;
	}
	
	@RequestMapping(value="/disable", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Result disable(@RequestBody EmailHistory emailHistory) {
		
		Result result = new Result();

		Username user =  usernameService.findByUsername(emailHistory.getEmail());
		user.setEnabled(false);
		usernameService.disableOrEnable(user);
		result.setCode("1");
		result.setDesc("successfully");
		return result;
	}
	

}
