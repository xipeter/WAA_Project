package mum.edu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.edu.domain.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin,Long> {

}
