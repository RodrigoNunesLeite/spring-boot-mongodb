package com.rodrigonunes.springbootmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigonunes.springbootmongo.domain.User;
import com.rodrigonunes.springbootmongo.repository.UserRepository;

@Service
public class UserService {
	
	/* Autowired = o spring instancia automaticamente o objeto
	 * */
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
