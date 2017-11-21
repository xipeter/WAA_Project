package mum.edu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.domain.OrderDelivery;
import mum.edu.repository.OrderDeliveryRepository;
import mum.edu.service.OrderDeliveryService;

@Service
public class OrderDeliveryServiceImpl implements OrderDeliveryService {
	
	@Autowired
	OrderDeliveryRepository orderDeliveryRepository;

	@Override
	public OrderDelivery save(OrderDelivery order) {
		return orderDeliveryRepository.save(order);
	}

	@Override
	public List<OrderDelivery> getOrderDeliveriesByRiderId(Long id) {
		return orderDeliveryRepository.listOrdersByRider(id);
	}

	@Override
	public OrderDelivery find(Long id) {
		return orderDeliveryRepository.findOne(id);
	}

	@Override
	public List<OrderDelivery> getOrderDeliveriesByRiderAndStatus(Long riderId, Long statusId) {
		return orderDeliveryRepository.listOrdersByRiderAndStatus(riderId, statusId);
	}

	@Override
	public void update(OrderDelivery order) {
		orderDeliveryRepository.save(order);
	}

	@Override
	public OrderDelivery findByTrackNumber(String trackNumber) {
		return orderDeliveryRepository.orderByTrackNumber(trackNumber);
	}
	
	@Override
	public List<OrderDelivery> getOrderDeliveriesByRestaurantId(Long id) {
		return orderDeliveryRepository.listOrdersByRestaurant(id);
	}
	
	@Override
	public String getNextTrackNo() {
		return String.valueOf(orderDeliveryRepository.getNextTrackNo() + 1);
	};

}
