package mum.edu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.edu.domain.Rider;

@Repository
public interface RiderRepository extends CrudRepository<Rider,Long> {

}
