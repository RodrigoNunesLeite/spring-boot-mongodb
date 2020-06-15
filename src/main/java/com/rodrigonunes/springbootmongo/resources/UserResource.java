package com.rodrigonunes.springbootmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigonunes.springbootmongo.domain.User;
import com.rodrigonunes.springbootmongo.dto.UserDTO;
import com.rodrigonunes.springbootmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		/*
		 * Primeiro converto a lista para uma stream, a stream
		 * é uma coleção que possibilita o uso de expressão lambda.
		 * Através de expressao lambada, estou pegando cada elemento x
		 * da lista list e instanciando um novo userDTO recebendo o objeto x,
		 * depois convertendo para lista novamente.
		 * */
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
