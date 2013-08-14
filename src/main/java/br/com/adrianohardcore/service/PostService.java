package br.com.adrianohardcore.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.adrianohardcore.model.Post;
import br.com.adrianohardcore.repository.PostRepository;

@Component(value="PageBuilderService")
public class PostService {
	private static final Logger LOGGER = LoggerFactory.getLogger(PostService.class);

	@Autowired
	private PostRepository repository;
	
	@Transactional
	public Page<Post> list(Pageable pageRequest){	
		LOGGER.debug("Lista de posts");		
		Page<Post> posts = repository.findAll(pageRequest);		
		
		return posts;
	}
}
