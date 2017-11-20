package mum.edu.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import mum.edu.domain.Restaurant;
import mum.edu.domain.Username;;

public interface UsernameService {
 	public Username findByUsername(String username);
 	public Username disableOrEnable(Username username);
 
}
