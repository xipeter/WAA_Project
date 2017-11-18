package mum.edu.service;

import java.util.List;

import mum.edu.domain.Restaurant;;
 
public interface RestaurantService {

	public void save(Restaurant member);
    	public void saveFull( Restaurant member);  		

	public List<Restaurant> findAll();
 	public Restaurant findOne(Long id);
	public List<Restaurant> findByName(String name);
 
}
