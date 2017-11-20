package mum.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import mum.edu.domain.OrderDelivery;
import mum.edu.domain.OrderStatus;
import mum.edu.service.OrderDeliveryService;

@Controller
public class RiderRestController {
	
	@Autowired
	OrderDeliveryService orderDeliveryService;
	
	@RequestMapping(value = "/acceptOrderDelivery/{deliveryOrderId}", method = RequestMethod.POST)
	public @ResponseBody OrderDelivery acceptOrder(@PathVariable(value = "deliveryOrderId") Long deliveryOrderId) {
		
		OrderDelivery order = orderDeliveryService.find(deliveryOrderId);
		
				
		return order;
	}

}
