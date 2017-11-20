package mum.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mum.edu.domain.Restaurant;
import mum.edu.domain.Username;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant,Long> {
	@Query("SELECT r FROM Restaurant r WHERE r.name LIKE CONCAT('%',:name,'%')")
	public List<Restaurant> findByName(@Param("name") String name);
	
	@Query("SELECT r FROM Restaurant r WHERE r.userCredentials.username =:username")
	public Restaurant findByUsername(@Param("username") String username);
}
