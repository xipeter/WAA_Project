package mum.edu.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.edu.domain.Username;


@Repository
public interface UsernameRepository extends CrudRepository<Username,String> {
  
	@Query("SELECT u from Username u WHERE u.username = :username")
	public Username findByUsername(String username);
	@Query(value="update Username u set u.enabled = 0 WHERE u.username= :username",nativeQuery = true)
	public void updateEnableByUsername(String username);
}
