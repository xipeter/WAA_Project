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
import mum.edu.serviceimpl.RestaurantServiceImpl;

@Controller
public class ApproveController {
	@Autowired 
	RestaurantServiceImpl restaurantService;
	@RequestMapping(value="/approve")
	public String approve(Model model) {
		List<Restaurant>  restaurants = restaurantService.findAll();
		model.addAttribute("restaurants", restaurants);
		return "approve";
	}
	@RequestMapping(value="/enable/{id}",method = RequestMethod.POST)
	public @ResponseBody Result enable(@PathVariable("id") String id) {
		
		Result result = new Result();
		result.setCode("1");
		result.setDesc("enable successfully");
		System.out.print(id);
		return result;
	}
	
	@RequestMapping(value="/disable/{id}",produces = "application/json")
	public @ResponseBody Result disable(@PathVariable("id") String id) {
		
		Result result = new Result();
		System.out.print(id);
		return result;
	}
	

}
