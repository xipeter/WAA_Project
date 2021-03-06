package mum.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mum.edu.domain.OrderDelivery;

@Repository
public interface OrderDeliveryRepository extends CrudRepository<OrderDelivery, Long> {
	
	@Query(value = "SELECT * FROM OrderDelivery WHERE rider_id = ?1", nativeQuery = true)
	public List<OrderDelivery> listOrdersByRider(Long id);
	
	@Query(value = "SELECT * FROM OrderDelivery WHERE rider_id = ?1 AND status_id = ?2", nativeQuery = true)
	public List<OrderDelivery> listOrdersByRiderAndStatus(Long riderId, Long statusId);
	
	@Query(value = "SELECT * FROM OrderDelivery WHERE trackNumber = ?1", nativeQuery = true)
	public OrderDelivery orderByTrackNumber(String trackNumber);
	
	@Query(value="SELECT * FROM OrderDelivery WHERE restaurant_id = ?1 ", nativeQuery = true)
	public List<OrderDelivery> listOrdersByRestaurant(@Param("id") Long id);
	
	@Query(value="SELECT tracKNumber FROM OrderDelivery order by tracKNumber desc limit 1;", nativeQuery = true)
	public int getNextTrackNo();

}
