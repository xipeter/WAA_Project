package mum.edu.repository;

import org.springframework.data.repository.CrudRepository;

import mum.edu.domain.Email;

public interface EmailRepsitory  extends CrudRepository<Email,Long>{

}
