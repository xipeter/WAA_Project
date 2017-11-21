package mum.edu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.edu.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}
