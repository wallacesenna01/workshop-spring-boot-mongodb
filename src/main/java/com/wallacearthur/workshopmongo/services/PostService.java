package com.wallacearthur.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallacearthur.workshopmongo.domain.Post;
import com.wallacearthur.workshopmongo.repository.PostRepository;
import com.wallacearthur.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;

			
		public Post findById(String id) {
			Optional<Post> obj = postRepository.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
		}
		
		public List<Post> findByTitle(String text){
			
			return postRepository.searchTitle(text);
		}
	
	}

