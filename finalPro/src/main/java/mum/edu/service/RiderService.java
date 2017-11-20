package mum.edu.service;

import mum.edu.domain.Rider;

public interface RiderService {

	Rider save(Rider rider);
	Rider findByUsername(String username);
	
}
