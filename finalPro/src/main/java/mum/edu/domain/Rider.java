package mum.edu.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;


@Entity 
public class Rider implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 	private Long id;
	
	@Column(length = 16)
	@NotEmpty
	@Size(min = 4, max = 16, message= "{Size.firstName.validation}")
	private String firstName;
	
	@Column(length = 16)
	@NotEmpty
	@Size(min=5, max = 9, message= "{Size.name.validation}")
	private String lastName;
	
	@Email
	@NotEmpty
	private String email;
	
	private String photoURL;
 	
	@OneToOne(cascade = CascadeType.ALL) 
 	@JoinColumn(name="username") 
 	Username userCredentials;
	
	@JsonIgnore
	@Transient
	private MultipartFile photo;
 	
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
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	public String getPhotoURL() {
		return photoURL;
	}
	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

}
