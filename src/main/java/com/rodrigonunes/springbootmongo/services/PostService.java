package com.rodrigonunes.springbootmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigonunes.springbootmongo.domain.Post;
import com.rodrigonunes.springbootmongo.repository.PostRepository;
import com.rodrigonunes.springbootmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	/*
	 * Autowired = o spring instancia automaticamente o objeto
	 */
	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		
		// somando a data mais 1 dia
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}

}
