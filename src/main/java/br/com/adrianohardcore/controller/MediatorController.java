package br.com.adrianohardcore.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.ResponseBody;
import br.com.adrianohardcore.model.Post;
import br.com.adrianohardcore.repository.PostRepository;

@Controller
@RequestMapping("/")
public class MediatorController {
	@Autowired
	private PostRepository postRepository;

	private Integer proximo = 0;
	private Integer anterior = 0;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String post(Model model) {
		// return posts(1, model);
		return "index/index";
	}

	@RequestMapping(value = "pagina/{page}", method = RequestMethod.GET)
	public String posts(@PathVariable Integer page, Model model) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageRequest = new PageRequest(page - 1, 5, sort);
		Page<Post> posts = postRepository.findAll(pageRequest);
		model.addAttribute("posts", posts.getContent());
		model.addAttribute("pagina", page);

		if (posts.hasNextPage()) {
			proximo = page + 1;
		}
		if (posts.hasPreviousPage()) {
			anterior = page - 1;
		}
		model.addAttribute("proximo", proximo);
		model.addAttribute("anterior", anterior);

		return "index/posts";
	}
	
	@RequestMapping(value = "/records")
	public String record(){	
		return "forward:records/1";
	}
	
	@RequestMapping(value = "/records2")
	public String record2(){	
		return "forward:records2/1";
	} 
	

	@RequestMapping(value = "/records/{page}", produces = "application/json")	
	public @ResponseBody List<Post> records(@PathVariable Integer page, Model model) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageRequest = new PageRequest(page - 1, 5, sort);  
		Page<Post> posts = postRepository.findAll(pageRequest);
		return posts.getContent() ;
	}
	
	@RequestMapping(value = "/records2/{page}")	
	public @ResponseBody Map<String,? extends Object> records2(@PathVariable Integer page, Model model) {
		
		Map<String,Object> postMap = new HashMap<String,Object>();
		Map<String,Object> postsMap = new HashMap<String,Object>();
		Map<String,Object> modelMap = new HashMap<String,Object>(3);	
		List<Object> postsList = new ArrayList();
		
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageRequest = new PageRequest(page - 1, 5, sort);  
		Page<Post> posts = postRepository.findAll(pageRequest);
		
		for (Post post : posts.getContent()) {
			postMap.put("id", post.getId());		
			postMap.put("title", post.getTitle());
			postMap.put("DataCriacao", post.getDataCriacao());
			postsMap.put("post", postMap);
			
			postsList.add(postMap);
			
			
			System.out.println("Títulos: "  + post.getTitle());
						
		}			
		postsMap.put("post", postsList);
		modelMap.put("data", posts.getContent());
		
		return postsMap ;
	}
}