package mum.edu.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.validator.constraints.Email;

@Entity
public class OrderDelivery implements Serializable{

	private static final long serialVersionUID = -3560539622417210365L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String address;
	
	@Email(message="email is required")
	private String email;
	
	private String customerName;
	
	private String trackNumber;
	
	//@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name = "status_id") 
	private OrderStatus status;
		
	//@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name = "restaurant_id") 
	private Restaurant restaurant;
	
	//@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name = "rider_id") 
	private Rider rider;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Rider getRider() {
		return rider;
	}

	public void setRider(Rider rider) {
		this.rider = rider;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getTrackNumber() {
		return trackNumber;
	}

	public void setTrackNumber(String trackNumber) {
		this.trackNumber = trackNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
