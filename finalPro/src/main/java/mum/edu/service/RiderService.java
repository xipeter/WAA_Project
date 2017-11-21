package mum.edu.service;

import java.util.List;

import mum.edu.domain.Rider;

public interface RiderService {

	Rider save(Rider rider);
	Rider findByUsername(String username);
	List<Rider> getAvailableRider();
	
}
