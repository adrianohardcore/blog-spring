package br.com.adrianohardcore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.adrianohardcore.model.Post;
import br.com.adrianohardcore.repository.PostRepository;

@Controller
@RequestMapping("/")
public class MediatorController {
	@Autowired
	private PostRepository postRepository;
	
	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String post(Model model) {
		return posts(1, model);
	}	

	@RequestMapping(value = "/{page}", method = RequestMethod.GET)
	public String posts(@PathVariable Integer page, Model model) {		
		Sort sort = new Sort(Direction.DESC, "id");		
		Pageable pageRequest = new PageRequest(page-1, 5 , sort);		
		Page<Post> posts = postRepository.findAll(pageRequest);			
		model.addAttribute("posts", posts.getContent());
		return "index/index";		
	}
}