package mum.edu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.domain.Restaurant;
import mum.edu.domain.Role;
import mum.edu.domain.Username;
import mum.edu.repository.RestaurantRepository;
import mum.edu.repository.UsernameRepository;
import mum.edu.service.RestaurantService;


@Service
@Transactional 
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private UsernameRepository usernameRepository;

//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void save( Restaurant restaurant) {  		
		restaurantRepository.save(restaurant);
	}


	@Override
//	@PreAuthorize("hasRole('ROLE_RESTAURANT')")
	public void saveFull( Restaurant restaurant) {  	
		usernameRepository.save(restaurant.getUserCredentials());
		restaurantRepository.save(restaurant);
	}

	public List<Restaurant> findAll() {
		return (List<Restaurant>)restaurantRepository.findAll();
	}

	public Restaurant findOne(Long id) {
		return restaurantRepository.findOne(id);
	}

	public List<Restaurant> findByName(String name) {
		return (List<Restaurant>) restaurantRepository.findByName(name);
	}

	public Restaurant findByUsername(String username) {
		return restaurantRepository.findByUsername(username);
	}
	
	public List<Restaurant> findRestaurant() {
		return restaurantRepository.findRestaurant();
	}
	public List<Restaurant> findDisabledRestaurant() {
		return restaurantRepository.findDisabledRestaurant();
	}

}
