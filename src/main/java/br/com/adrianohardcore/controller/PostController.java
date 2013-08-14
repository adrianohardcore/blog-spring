package br.com.adrianohardcore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.adrianohardcore.dto.SearchDTO;
import br.com.adrianohardcore.model.Comment;
import br.com.adrianohardcore.model.Post;
import br.com.adrianohardcore.repository.CommentRepository;
import br.com.adrianohardcore.repository.PostRepository;

@Controller
@RequestMapping("/posts/**")
public class PostController {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private CommentRepository commentRepository;

	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public String show(@PathVariable Long id, ModelMap modelMap) {
		Post post = postRepository.findOne(id);
		modelMap.addAttribute("post", postRepository.findOne(id));
		modelMap.addAttribute("comments", commentRepository.findByPost(post));
		modelMap.addAttribute("comment", new Comment());
		return "posts/show";
	}

//	@RequestMapping(value = "/posts", method = RequestMethod.GET)
//	public String list(ModelMap modelMap) {
//		modelMap.addAttribute("posts", postRepository.findAll());
//		return "posts/list";
//	}
	

	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public String list(ModelMap model){		
		Sort sort = new Sort(Direction.DESC, "id"); 
		Pageable pageRequest = new PageRequest(1 - 1, 5, sort);   
		Page<Post> posts = postRepository.findAll(pageRequest);
		
		String search = "teste";		
		model.addAttribute("search", search);		
		model.addAttribute("posts", posts.getContent());		

		return "posts/list";
	}	
	
//	@RequestMapping(value = "/postsearch", method = RequestMethod.POST)
//	@ResponseBody
//	public String search(@RequestBody String search,ModelMap model){		
//		Sort sort = new Sort(Direction.DESC, "id");
//		Pageable pageRequest = new PageRequest(1 - 1, 5, sort);		
//		Page<Post> posts = postRepository.findByTitleLike(search, pageRequest);
//		model.addAttribute("posts", posts.getContent());		
//		return "posts/list";
//	}
	
	@RequestMapping(value = "/postsearch", method = RequestMethod.POST)
    @ResponseBody
    public Page<Post> search(@RequestBody SearchDTO searchCriteria) {        
        String searchTerm = searchCriteria.getSearchTerm();        
		Sort sort = new Sort(Direction.DESC, "id");		
		//Pageable pageRequest = new PageRequest(1 - 1, 5, sort);		
		Pageable pageRequest = new PageRequest(1 -1,5 , sort);
		//Page<Post> posts = postRepository.findByTitleLike(searchTerm, searchCriteria.getPageIndex(),pageRequest);		
		Page<Post> posts = postRepository.findAll(pageRequest);
		return posts;
    }
	
//    @RequestMapping(value = "/person/search/page", method = RequestMethod.POST)
//    @ResponseBody
//    public List<PersonDTO> search(@RequestBody SearchDTO searchCriteria) {
//        LOGGER.debug("Searching persons with search criteria: " + searchCriteria);
//        
//        String searchTerm = searchCriteria.getSearchTerm();
//        List<Person> persons = personService.search(searchTerm, searchCriteria.getPageIndex());
//        LOGGER.debug("Found " + persons.size() + " persons");
//
//        return constructDTOs(persons);
//    }

	
	

	@RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		postRepository.delete(postRepository.findOne(id));
		return "redirect:/posts";
	}

	@RequestMapping(value = "/posts/form", method = RequestMethod.GET)
	public String form(ModelMap modelMap) {
		modelMap.addAttribute("post", new Post());
		return "posts/create";
	}

	@RequestMapping(value = "/posts", method = RequestMethod.POST)
	public String create(@Valid Post post, BindingResult result) {
		if (result.hasErrors())
			return "posts/create";
		
		postRepository.save(post);
		return "redirect:/posts";
	}	
	
	@RequestMapping(value = "/posts", method = RequestMethod.PUT)
	public String update(@Valid Post post, BindingResult result) {
		if (result.hasErrors())
			return "posts/update";

		postRepository.save(post);
		return "redirect:/posts";
	}	

	@RequestMapping(value = "/posts/{id}/form", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, ModelMap modelMap) {
		modelMap.addAttribute("post", postRepository.findOne(id));
		return "posts/update";
	}

	@RequestMapping(value = "/posts/{id}", method = RequestMethod.POST)
	public String createComment(@Valid Comment comment, BindingResult result,
			@PathVariable("id") Long id) {
		Post post = postRepository.findOne(id);
		if (result.hasErrors())
			return "posts/" + id;

		comment.setId(null);
		comment.setPost(post);
		commentRepository.save(comment);
		return "redirect:/posts/" + id;
	}
}
