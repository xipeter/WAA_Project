package mum.edu.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.edu.domain.OrderDelivery;
import mum.edu.domain.Restaurant;
import mum.edu.domain.Role;
import mum.edu.domain.Username;
import mum.edu.service.OrderDeliveryService;
import mum.edu.service.RestaurantService;
import mum.edu.service.UsernameService;

@Controller
public class RestaurantController {
	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	UsernameService usernameService;
	
	@Autowired
	OrderDeliveryService orderDeliveryService;

	@RequestMapping(value= {"/restaurant","/restaurant/"}, method = RequestMethod.GET)
	public String showRestaurant(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Restaurant res = restaurantService.findByUsername(username);
        List<OrderDelivery> list = orderDeliveryService.getOrderDeliveriesByRestaurantId(res.getId());
        model.addAttribute("orders", list );
        
 		return "restaurant";
	}
	
	@RequestMapping(value= {"/restaurantOrderDelivery"}, method = RequestMethod.GET)
	public String showRestaurantOrderDelivery() {
 		return "restaurantOrderDelivery";
	}
	
	@RequestMapping(value="/restaurantSignup", method = RequestMethod.GET)
	public String signupRestaurant(@ModelAttribute("restaurant") Restaurant restaurant) {
 		return "restaurantSignup";
	}
	
	@RequestMapping(value="/restaurantSignup", method = RequestMethod.POST)
	public String signupRestaurant(@Valid @ModelAttribute("restaurant") Restaurant restaurant, 
			BindingResult bindingResult) {
		System.out.println("load page restaurantSignup ");
		
		if(bindingResult.hasErrors()) {
			return "restaurantSignup";
		}
		
		restaurant.getUserCredentials().setUsername(restaurant.getEmail());
		
		Role role = new Role();
		role.setUsername(restaurant.getEmail());
		role.setRole("ROLE_RESTAURANT");
		List<Role> roles = new ArrayList<>();
		roles.add(role);
		
		restaurant.getUserCredentials().setRole(roles);
		restaurant.getUserCredentials().setEnabled(false);
		restaurant.getUserCredentials().setUID(UUID.randomUUID().toString());
		restaurantService.saveFull(restaurant);
 		
		return "redirect:/restaurantSignupThank";
	}
	
	@RequestMapping(value="/restaurantSignupThank", method = RequestMethod.GET)
	public String signupThank(Model model) {
 		return "restaurantSignupThank";
	}
	
	@RequestMapping(value="/restaurantProfile", method = RequestMethod.GET, produces = "application/json")
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
