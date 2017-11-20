package mum.edu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.edu.domain.OrderStatus;

@Repository
public interface OrderStatusRepository extends CrudRepository<OrderStatus, Long>  {
	

}
