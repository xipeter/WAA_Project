package mum.edu.webflow;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mum.edu.domain.OrderDelivery;
import mum.edu.service.OrderDeliveryService;
import mum.edu.service.RiderService;
import mum.edu.domain.Rider;

@Component
public class OrderDeliveryControllerHelper {

	@Autowired
	OrderDeliveryService orderDeliveryService;
	
	@Autowired
	RiderService riderService;
	
	public OrderDelivery saveOrderDelivery(OrderDelivery orderDelivery, Rider rider) {
		orderDelivery.setRider(rider);
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
