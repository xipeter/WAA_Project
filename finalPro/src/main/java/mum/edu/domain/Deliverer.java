package mum.edu.domain;

import org.springframework.web.multipart.MultipartFile;

//@Entity
public class Deliverer {
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//@JsonIgnore
	private MultipartFile photo;

}
