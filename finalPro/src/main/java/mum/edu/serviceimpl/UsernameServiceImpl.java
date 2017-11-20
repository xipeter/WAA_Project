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
	
	@PreAuthorize("hasRole('ROLE_RESTAURANT') or hasRole('ROLE_ADMIN')")
	public Username findByUsername(String username) {
		return usernameRepository.findByUsername(username);
	}

	@Override
	public Username disableOrEnable(Username username) {
		// TODO Auto-generated method stub
//		return usernameRepository.updateEnableByUsername(username);
		return usernameRepository.save(username);
	}

}
