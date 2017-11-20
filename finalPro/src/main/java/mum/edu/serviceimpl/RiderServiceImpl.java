package mum.edu.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.domain.Rider;
import mum.edu.repository.RiderRepository;
import mum.edu.service.RiderService;

@Service
public class RiderServiceImpl implements RiderService {
	
	@Autowired
	RiderRepository riderRepository;

	@Override
	public Rider save(Rider rider) {
		return riderRepository.save(rider);
	}

}
