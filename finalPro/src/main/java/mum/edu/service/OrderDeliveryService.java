package mum.edu.service;

import java.util.List;

import mum.edu.domain.OrderDelivery;

public interface OrderDeliveryService {
	
	OrderDelivery save(OrderDelivery order);
	
	OrderDelivery find(Long id);
	
	OrderDelivery findByTrackNumber(String trackNumber); 
	
	List<OrderDelivery> getOrderDeliveriesByRiderId(Long id);
	
	List<OrderDelivery> getOrderDeliveriesByRiderAndStatus(Long riderId, Long statusId);
	
	void update(OrderDelivery order);

}
