package com.rodrigonunes.springbootmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigonunes.springbootmongo.domain.User;
import com.rodrigonunes.springbootmongo.dto.UserDTO;
import com.rodrigonunes.springbootmongo.repository.UserRepository;
import com.rodrigonunes.springbootmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	/*
	 * Autowired = o spring instancia automaticamente o objeto
	 */
	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
