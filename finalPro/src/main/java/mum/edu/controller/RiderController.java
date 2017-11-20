package mum.edu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.edu.domain.Rider;
import mum.edu.domain.Role;
import mum.edu.service.RiderService;

@Controller
public class RiderController {
	
	@Autowired
	RiderService riderService;
	
	@RequestMapping(value = "/rider", method = RequestMethod.GET)
	public String displayDelivererHome() {
		return "DelivererHome";
	}
	
	// Rider sign Up
	@RequestMapping(value = "/riderSignup", method = RequestMethod.GET)
	public String getRiderSignupForm(@ModelAttribute("newRider") Rider rider) {
		return "rider/riderSignup";
	}
	
	@RequestMapping(value = "/processRider", method = RequestMethod.POST)
	public String processRiderSignupForm(
			@Valid @ModelAttribute("newRider") Rider rider,
			BindingResult bindingResult
	) {
		
		if (bindingResult.hasErrors()) {
			return "rider/riderSignup";
		}
		
		Role role = new Role();
		role.setUsername(rider.getEmail());
		
		
		rider.getUserCredentials().setUsername(rider.getEmail());
		riderService.save(rider);
		
		return "redirect:/riderSuccess";
	}
	
	@RequestMapping(value = "/riderSuccess")
	public String successRiderSignup() {
		return "rider/riderSuccess";
	}
	
	// Rider home
	@RequestMapping(value = "/riderHome")
	public String getRiderHome(Model model) {
		return "rider/riderHome";
	}
	
	

}
