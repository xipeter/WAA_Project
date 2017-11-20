package mum.edu.service;

import java.util.List;

import mum.edu.domain.Restaurant;
import mum.edu.domain.Username;;
 
public interface RestaurantService {

	public void save(Restaurant member);
    	public void saveFull( Restaurant member);  		

	public List<Restaurant> findAll();
 	public Restaurant findOne(Long id);
 	public Restaurant findByUsername(String username);
	public List<Restaurant> findByName(String name);
	public List<Restaurant> findRestaurant();
	public List<Restaurant> findDisabledRestaurant() ;
 
}
