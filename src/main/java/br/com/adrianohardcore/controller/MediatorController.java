package br.com.adrianohardcore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	// @RequestMapping
	// public String getHomePage() {
	// return "index/index";
	// }

	// @RequestMapping
	// public String list(ModelMap modelMap) {
	// Pageable pageRequest = new PageRequest(1,3);
	// Page<Post> posts = postRepository.findAll(pageRequest);
	// //modelMap.addAttribute("posts", postRepository.findAll());
	// modelMap.addAttribute("posts", posts);
	// //modelMap.addAttribute("posts", posts);
	// return "index/index";
	// }

	// @RequestMapping
	// public @ResponseBody
	// String list(ModelMap modelMap,
	// @RequestParam(value = "page", required = false) Integer page,
	// @RequestParam(value = "rows", required = false) Integer rows) {
	//
	// Pageable pageRequest = new PageRequest(page - 1, rows);
	//
	// Page<Post> posts = postRepository.findAll(pageRequest);
	// modelMap.addAttribute("posts", posts);
	// return "index/index";
	// }

	// @RequestMapping(produces = "text/html")
	// public String list(
	// @RequestParam(value = "page",
	// required = false) Integer page,
	// @RequestParam(value = "size",
	// required = false) Integer size,
	// Model uiModel) {
	//
	// Pageable pageRequest = new PageRequest(page - 1, size);
	//
	// Page<Post> posts = postRepository.findAll(pageRequest);
	// uiModel.addAttribute("posts", posts);
	// return "index/index";
	// }

	// @RequestMapping
	// @ResponseBody
	// public String list(
	// @RequestParam("page") int page,
	// @RequestParam("size") int size,
	// UriComponentsBuilder uriBuilder,
	// HttpServletResponse response,
	// Model model
	// ) {
	//
	// Pageable pageRequest = new PageRequest(page - 1, size);
	//
	// Page<Post> posts = postRepository.findAll(pageRequest);
	// model.addAttribute("posts", posts);
	//
	// return "index/index";
	// }

	@RequestMapping(value = "/{page}/{row}", method = RequestMethod.GET)
	public String list(@PathVariable Integer page,Integer row, Model model) {
		 Pageable pageRequest = new PageRequest(page - 1, row);
		
		 Page<Post> posts = postRepository.findAll(pageRequest);
		 model.addAttribute("posts", posts);
		
		 return "index/index";

	}

}