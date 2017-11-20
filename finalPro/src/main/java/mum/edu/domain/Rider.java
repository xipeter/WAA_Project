package mum.edu.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity 
public class Rider {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 	private Long id;
	
	@Column(length = 16)
	@NotEmpty
	@Size(min = 4, max = 16)
	private String firstName;
	
	@Column(length = 16)
	@NotEmpty
	@Size(min=5, max = 9, message= "{EmptyOrSize}")
	private String lastName;
	
	@Email
	@NotEmpty
	@JsonIgnore
	private String email;
 	
	@OneToOne(cascade = CascadeType.ALL) 
 	@JoinColumn(name="username") 
 	Username userCredentials;
 	
 	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

  }
