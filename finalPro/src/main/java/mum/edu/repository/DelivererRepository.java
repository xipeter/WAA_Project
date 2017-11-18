package mum.edu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.edu.domain.Deliverer;

@Repository
public interface DelivererRepository extends CrudRepository<Deliverer,Long> {

}
