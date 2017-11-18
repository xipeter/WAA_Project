package mum.edu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestaurantController {

	@RequestMapping(value="/restaurant", method = RequestMethod.GET)
	public String showRestaurant() {
 		return "restaurant";
	}
	
	@RequestMapping(value="/restaurantSignup", method = RequestMethod.GET)
	public String signupRestaurant() {
 		return "restaurantSignup";
	}
}
