package mum.edu.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import mum.edu.domain.OrderDelivery;
import mum.edu.domain.Rider;
import mum.edu.domain.Role;
import mum.edu.repository.RoleRepository;
import mum.edu.service.OrderDeliveryService;
import mum.edu.service.RestaurantService;
import mum.edu.service.RiderService;

@Controller
public class RiderController {
	
	@Autowired
	RiderService riderService;
	
	@Autowired
	OrderDeliveryService orderDeliveryService;
	
	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	RoleRepository roleRepository;
	
	@RequestMapping(value = "/rider", method = RequestMethod.GET)
	public String displayDelivererHome() {
		return "DelivererHome";
	}
	
	// Rider sign Up
	@RequestMapping(value = "/riderSignup", method = RequestMethod.GET)
	public String getRiderSignupForm(@ModelAttribute("newRider") Rider rider) {
		return "rider/riderSignup";
	}
	
	@RequestMapping(value = "/processRider", method = RequestMethod.POST)
	public String processRiderSignupForm(
			@Valid @ModelAttribute("newRider") Rider rider,
			BindingResult bindingResult
	) {
		
		if (bindingResult.hasErrors()) {
			return "rider/riderSignup";
		}
		
		MultipartFile employeePhoto = rider.getPhoto();
		String rootDirectory = servletContext.getRealPath("/");
		String userUID = UUID.randomUUID().toString();
		
		if (employeePhoto != null && !employeePhoto.isEmpty()) {
			try {
				
				String photoURL = rootDirectory + "resources/images/" + userUID + ".png";
				employeePhoto.transferTo(new File(photoURL));
				rider.setPhotoURL(userUID);
				
			} catch (Exception e) {
				throw new RuntimeException("Employee photo saving failed", e);
				//throw new UnableToUploadPhotoException("Employee photo saving failed");
			}
		}
		
		Role role = new Role();
		role.setUsername(rider.getEmail());
		role.setRole("ROLE_RIDER");
		List<Role> roles = new ArrayList<>();
		
		rider.getUserCredentials().setRole(roles);
		rider.getUserCredentials().setUsername(rider.getEmail());
		rider.getUserCredentials().setUID(userUID);
		rider.getUserCredentials().setEnabled(false);
		riderService.save(rider);
		roleRepository.save(role);
		
		return "redirect:/riderSuccess";
	}
	
	@RequestMapping(value = "/riderSuccess")
	public String successRiderSignup() {
		return "rider/riderSuccess";
	}
	
	// Rider home
	@RequestMapping(value = "/riderHome")
	public String getRiderHome(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Rider rider = riderService.findByUsername(username);
        
		List<OrderDelivery> requestedOrders = orderDeliveryService.getOrderDeliveriesByRiderAndStatus(rider.getId(), 1L);
		model.addAttribute("requestedOrders", requestedOrders);
		
		List<OrderDelivery> currentOrders = orderDeliveryService.getOrderDeliveriesByRiderAndStatus(rider.getId(), 2L);
		model.addAttribute("currentOrders", currentOrders);
		
		model.addAttribute("rider", rider);
		
		return "rider/riderHome";
	}
	
	@RequestMapping(value = "/riderProfile", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_RIDER')")
	public @ResponseBody Rider getProfile() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
		
        Rider rider = riderService.findByUsername(username);
        
        return rider;
        
	}
	
}
