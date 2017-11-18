package mum.edu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.edu.domain.Username;


@Repository
public interface UsernameRepository extends CrudRepository<Username,String> {
  
	public Username findByUsername(String username);
}
