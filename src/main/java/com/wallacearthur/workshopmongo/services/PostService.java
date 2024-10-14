package com.wallacearthur.workshopmongo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

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
		
		public List<Post> fullSearch(String text, Date minDate, Date maxDate){
			maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
			return postRepository.fullSearch(text, minDate, maxDate);
		}
		
		public static Date convertDate(String textDate, Date defaultValue) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sdf.setTimeZone(TimeZone.getTimeZone("GTM"));
			try {
				return sdf.parse(textDate);
			} catch (ParseException e) {
				return defaultValue;
			}
		}
	
	}

