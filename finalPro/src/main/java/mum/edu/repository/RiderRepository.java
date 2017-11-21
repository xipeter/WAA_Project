package mum.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.edu.domain.Rider;

@Repository
public interface RiderRepository extends CrudRepository<Rider,Long> {
	
	@Query(value = "SELECT * FROM Rider WHERE username = ?1", nativeQuery = true)
	public Rider findRiderByUsername(String username);
	
	@Query(value= "SELECT r.* FROM Rider r \n" + 
			"WHERE r.id NOT IN (\n" + 
			"SELECT distinct o.rider_id \n" + 
			"FROM OrderDelivery o \n" + 
			"WHERE o.status_id = 2\n" + 
			")" , nativeQuery = true)
	public List<Rider> getAvailableRider();

}
