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


@Entity 
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 	private Long id;

	@OneToOne(fetch=FetchType.LAZY) 
 	@JoinColumn(name="username") 
 	Username userCredentials;
 	
 	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
 	public Username getUserCredentials() {
		return userCredentials;
	}
	public void setUserCredentials(Username userCredentials) {
		this.userCredentials = userCredentials;
	}

  }
