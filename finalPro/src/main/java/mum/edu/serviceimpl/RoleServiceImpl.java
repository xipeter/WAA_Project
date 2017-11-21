package mum.edu.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import mum.edu.domain.Role;
import mum.edu.repository.RoleRepository;
import mum.edu.service.RoleService;

public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}

}
