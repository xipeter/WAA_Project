package mum.edu.service;

import java.util.List;

import mum.edu.domain.Rider;

public interface RiderService {

	Rider save(Rider rider);
	Rider findByUsername(String username);
	void saveFull(Rider rider);
	List<Rider> getAvailableRider();
	public Rider findById(Long id);
	
}
