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
	
	@RequestMapping(value="/profile", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_RESTAURANT')")
	public @ResponseBody Restaurant getProfile() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        
        Restaurant restaurant = new Restaurant();
        try {
        		Restaurant res = restaurantService.findByUsername(username);
        		
        		restaurant.setId(res.getId());
        		restaurant.setName(res.getName());
        		restaurant.setFirstName(res.getFirstName());
        		restaurant.setLastName(res.getLastName());
        		restaurant.setAddress(res.getAddress());
        		restaurant.setEmail(res.getEmail());
        		restaurant.setNote(res.getNote());
        }catch (Exception e){
        		System.out.println("Error: " +e);
        }
        
        System.out.println(restaurant);
        
 		return restaurant;
	}
}
