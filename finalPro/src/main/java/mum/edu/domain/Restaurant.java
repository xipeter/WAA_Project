package mum.edu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import mum.edu.validator.Address;


@Entity 
public class Restaurant {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 	private Long id;
	
	@NotEmpty
	@Size(min=2, max = 100, message= "{EmptyOrSize}")
	private String name;
	
	@Column(length = 50)
	@NotEmpty
	@Size(min=2, max = 50, message= "{EmptyOrSize}")
	private String firstName;
	
	@Column(length = 50)
	@NotEmpty
	@Size(min=2, max = 50, message= "{EmptyOrSize}")
	private String lastName;
 	
	@Column(length = 100)
	@Address
	private String address;
	
	private String email;
	
	private String note;
//	private String photo;
	

	@OneToOne(fetch=FetchType.LAZY) 
 	@JoinColumn(name="username") 
 	Username userCredentials;
	
	public Restaurant() {}
 	
 	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
 
	
 	public Username getUserCredentials() {
		return userCredentials;
	}
	public void setUserCredentials(Username userCredentials) {
		this.userCredentials = userCredentials;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
  }
