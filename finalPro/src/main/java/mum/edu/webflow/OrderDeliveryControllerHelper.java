package mum.edu.webflow;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import mum.edu.domain.OrderDelivery;
import mum.edu.domain.OrderStatus;
import mum.edu.domain.Restaurant;
import mum.edu.service.OrderDeliveryService;
import mum.edu.service.RestaurantService;
import mum.edu.service.RiderService;
import mum.edu.domain.Rider;

@Component
public class OrderDeliveryControllerHelper {

	@Autowired
	OrderDeliveryService orderDeliveryService;
	
	@Autowired
	RiderService riderService;
	
	@Autowired
	RestaurantService restaurantService;
	
	public OrderDelivery saveOrderDelivery(OrderDelivery orderDelivery, Rider rider) {
		OrderStatus orderStatus = new OrderStatus();
		orderStatus.setId(new Long(1));
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
		Restaurant res =	 restaurantService.findByUsername(username);
		
		orderDelivery.setRider(rider);
		orderDelivery.setStatus(orderStatus);
		orderDelivery.setRestaurant(res);
		orderDelivery.setTrackNumber(orderDeliveryService.getNextTrackNo());
		
		return orderDeliveryService.save(orderDelivery);
	}
	
	public OrderDelivery initiate() {
		OrderDelivery orderDeliver = new OrderDelivery();
		return orderDeliver;
	}
	
	public Rider getAvailableRider(){
		List<Rider> list = riderService.getAvailableRider();

		return list.get(0);
	}
	
}
