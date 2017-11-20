package mum.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mum.edu.domain.Restaurant;
import mum.edu.domain.Result;
import mum.edu.domain.Username;
import mum.edu.service.RestaurantService;
import mum.edu.service.UsernameService;


@Controller
public class ApproveController {
	@Autowired 
	RestaurantService restaurantService;
	@Autowired
	UsernameService usernameService;
	@RequestMapping(value="/approve")
	public String approve(Model model) {
		List<Restaurant>  restaurants = restaurantService.findRestaurant();//enabled users
		List<Restaurant>  restaurantsDisabled = restaurantService.findDisabledRestaurant();//disabled users
		model.addAttribute("restaurants", restaurants);
		model.addAttribute("restaurants_disabled", restaurantsDisabled);
		return "approve";
	}
	@RequestMapping(value="/enable/{id}",method = RequestMethod.POST,produces="application/json")
	public @ResponseBody Result enable(@PathVariable("id") String id) {
		
		Result result = new Result();
		result.setCode("1");
		result.setDesc("successfully");
		System.out.print(id);
		return result;
	}
	
	@RequestMapping(value="/disable/{id}", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Result disable(@PathVariable("id") String id) {
		
		Result result = new Result();
		System.out.print(id);
		usernameService.disable(id);
		result.setCode("1");
		result.setDesc("successfully");
		return result;
	}
	

}
