package mum.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import mum.edu.domain.OrderDelivery;
import mum.edu.domain.OrderStatus;
import mum.edu.exception.OrderNotFoundException;
import mum.edu.service.OrderDeliveryService;
import mum.edu.service.OrderStatusService;

@Controller
public class RiderRestController {
	
	@Autowired
	OrderDeliveryService orderDeliveryService;
	
	@Autowired
	OrderStatusService orderStatusService;
	
	@RequestMapping(value = "/acceptOrderDelivery/{deliveryOrderId}", method = RequestMethod.POST)
	public @ResponseBody OrderDelivery acceptOrder(@PathVariable(value = "deliveryOrderId") Long deliveryOrderId) {
		
		OrderDelivery order = orderDeliveryService.find(deliveryOrderId);
		OrderStatus newStatus = orderStatusService.find(2L);
		order.setStatus(newStatus);
		
		orderDeliveryService.update(order);
		
		return order;
	}
	
	@RequestMapping(value = "/completeOrderDelivery/{deliveryOrderId}/{orderTrackNumber}", method = RequestMethod.POST)
	public @ResponseBody OrderDelivery completeOrder(
			@PathVariable(value = "deliveryOrderId") Long deliveryOrderId,
			@PathVariable(value = "orderTrackNumber") String orderTrackNumber
	) {
		
		OrderDelivery order = orderDeliveryService.find(deliveryOrderId);
		
		if (!orderTrackNumber.equalsIgnoreCase(order.getTrackNumber())) {
			throw new OrderNotFoundException("Order not found");
		}
		
		OrderStatus newStatus = orderStatusService.find(3L);
		order.setStatus(newStatus);
		
		orderDeliveryService.update(order);
		
		return order;
	}

}
