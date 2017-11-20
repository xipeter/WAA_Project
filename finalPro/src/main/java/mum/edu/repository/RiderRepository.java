package mum.edu.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.edu.domain.Rider;

@Repository
public interface RiderRepository extends CrudRepository<Rider,Long> {
	
	@Query(value = "SELECT * FROM Rider WHERE username = ?1", nativeQuery = true)
	public Rider findRiderByUsername(String username);

}
