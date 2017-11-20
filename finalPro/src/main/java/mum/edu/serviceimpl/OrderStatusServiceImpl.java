package mum.edu.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.domain.OrderStatus;
import mum.edu.repository.OrderStatusRepository;
import mum.edu.service.OrderStatusService;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {
	
	@Autowired
	OrderStatusRepository orderStatusRepository;

	@Override
	public OrderStatus find(Long id) {
		return orderStatusRepository.findOne(id);
	}

}
