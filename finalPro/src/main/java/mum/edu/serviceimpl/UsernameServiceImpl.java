package mum.edu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.domain.Restaurant;
import mum.edu.domain.Username;
import mum.edu.repository.RestaurantRepository;
import mum.edu.repository.UsernameRepository;
import mum.edu.service.RestaurantService;
import mum.edu.service.UsernameService;


@Service
@Transactional 
public class UsernameServiceImpl implements UsernameService {
	
	@Autowired
	private UsernameRepository usernameRepository;

	public Username findByUsername(String username) {
		return usernameRepository.findByUsername(username);
	}

}
