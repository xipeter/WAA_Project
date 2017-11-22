package mum.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mum.edu.domain.OrderDelivery;
import mum.edu.domain.Rider;
import mum.edu.service.OrderDeliveryService;
import mum.edu.service.RiderService;


@Controller
public class TrackController {

	@Autowired
	OrderDeliveryService orderDeliveryService;
	@Autowired
	RiderService riderService;
	@RequestMapping("/track")
	public String track(@Param("number") String number,Model model) {
		System.out.println(number);
		 OrderDelivery status =  this.orderDeliveryService.findByTrackNumber( number);
		 
		 Rider rider = this.riderService.findById(status.getStatus().getId());
		 
		 model.addAttribute("status", status);
		 model.addAttribute("rider", rider);
		 
		 
		return "track";
	}
}
