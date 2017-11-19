package mum.edu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mum.edu.domain.Restaurant;
import mum.edu.domain.Username;
import mum.edu.service.RestaurantService;
import mum.edu.service.UsernameService;

@Controller
@RequestMapping(value="/restaurant")
public class RestaurantController {
	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	UsernameService usernameService;

	@RequestMapping(value= {"/",""}, method = RequestMethod.GET)
	public String showRestaurant() {
 		return "restaurant/restaurant";
	}
	
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public String signupRestaurant() {
 		return "restaurant/restaurantSignup";
	}
	
	@RequestMapping(value="/profile", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_RESTAURANT')")
	public @ResponseBody String getProfile() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        
        System.out.println("profile page requested "+ username);
        
 		return restaurantService.findByUsername(username).toString();
	}
}
