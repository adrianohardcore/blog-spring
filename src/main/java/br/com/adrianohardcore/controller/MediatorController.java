package br.com.adrianohardcore.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.adrianohardcore.dto.PostDto;
import br.com.adrianohardcore.dto.PostMapper;
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
	
	@RequestMapping(value="page/{page}", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody List<PostDto> page(@PathVariable Integer page, Model model){
		if (page < 1)
			page = 1;		
		
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageRequest = new PageRequest(page - 1, 5, sort);
		Page<Post> posts = postRepository.findAll(pageRequest);
		List<PostDto> userDtos = PostMapper.map(posts);
		return userDtos;
	}
	
	@RequestMapping(value="page", produces="application/json")
	public @ResponseBody List<PostDto> page2(@RequestParam Integer page,Model model){
		//Integer page = 1;
		//if (page < 1)
		//	page = 1;		
		
		Sort sort = new Sort(Direction.DESC, "id");   
		Pageable pageRequest = new PageRequest(page - 1, 5, sort);
		Page<Post> posts = postRepository.findAll(pageRequest);
		List<PostDto> postDtos = PostMapper.map(posts);
		model.addAttribute("pagina", posts.getSize());
		
		return postDtos;
	}
			

//	@RequestMapping(value = "/records")
//	public String record() {
//		return "forward:records/1";
//	}
//
//	@RequestMapping(value = "/records2")
//	public String record2() {
//		return "forward:records2/1";
//	}
//
//	@RequestMapping(value = "/records/{page}", produces = "application/json")
//	public @ResponseBody
//	List<Post> records(@PathVariable Integer page, Model model) {
//		Sort sort = new Sort(Direction.DESC, "id");
//		Pageable pageRequest = new PageRequest(page - 1, 5, sort);
//		Page<Post> posts = postRepository.findAll(pageRequest);
//		return posts.getContent();
//	}
//	
//	@RequestMapping(value = "/records2/{page}", produces = "application/json")
//	public @ResponseBody List<Object> records2(@PathVariable Integer page, Model model) {
//		Sort sort = new Sort(Direction.DESC, "id");
//		Pageable pageRequest = new PageRequest(page - 1, 5, sort);
//		Page<Post> posts = postRepository.findAll(pageRequest);		
//		Map<String, Object> postMap = new HashMap<String, Object>();		
//		List<Object> postList = new ArrayList<Object>();		
//		for (Post post : posts.getContent()) {
//			postMap.put("id", post.getId());			
//			postMap.put("title", post.getTitle());
//			postMap.put("DataCriacao", post.getDataCriacao());			
//			postList.add(postMap);
//			//postList.addAll(postMap.values());
//		}				
//		return postList;
//	}

//	@RequestMapping(value = "/records2/{page}", produces = "application/json")
//	public @ResponseBody List<Object> records2(@PathVariable Integer page, Model model) {
//		Sort sort = new Sort(Direction.DESC, "id");
//		Pageable pageRequest = new PageRequest(page - 1, 5, sort);
//		Page<Post> posts = postRepository.findAll(pageRequest);		
//		
//		Map<String, Object> postMap = new HashMap<String, Object>();
//		Map<String, Object> postsMap = new HashMap<String, Object>();
//		
//		List<Object> postList = new ArrayList();
//		
//		//postMap.put("id", posts.getContent()     );
//		
//		for (Post post : posts.getContent()) {
//			postMap.put("id", post.getId());			
//			postMap.put("title", post.getTitle());
//			postMap.put("DataCriacao", post.getDataCriacao());
//			
//			postList.add(postMap);
//			//postList.addAll(postMap.values());
//			//postList.add(postMap);
//			
//			postsMap.putAll(postMap);			
//			//postsMap.put("post", postMap.values()); 
//		}
//		
//		//postsMap.put("post", postList);
//		
//		for (Object object : postsMap.values()) {
//			System.out.println("--------------------------------"+object);			
//		}		
//				
//		return postList;
//	}

	
	
	
	
//	@RequestMapping(value = "/records2/{page}")
//	//public @ResponseBody Map<String, ? extends Object> records2(@PathVariable Integer page, Model model) {
//	public @ResponseBody Object records2(@PathVariable Integer page, Model model) {
//
//		Sort sort = new Sort(Direction.DESC, "id");
//		Pageable pageRequest = new PageRequest(page - 1, 5, sort);
//		Page<Post> posts = postRepository.findAll(pageRequest);
//
//		Map<String, Object> postMap = new HashMap<String, Object>();
//		Map<String, Object> postsMap = new HashMap<String, Object>();
//		Map<String, Object> modelMap = new HashMap<String, Object>(3);
//
//		// List<Object> postList = new ArrayList();
//		List<Object> postsList = new ArrayList();
//
//		//postsMap.put("post", posts.getContent());		
//		
//		JsonResponse res = new JsonResponse();		
//		
//
//		for (Post post : posts.getContent()) {
//			postMap.put("id", post.getId());
//			postMap.put("title", post.getTitle());
//			postMap.put("DataCriacao", post.getDataCriacao());
//			
//		
//			res.salvarLista(postMap);
//			
////			postsMap.put(post.getId().toString(), postMap);			
////			postsList.add(postMap);			
////			System.out.println("########################################" + postsList.get(0));
////			System.out.println("Títulos: " + post.getTitle());
//		}		
//		
//		
//		
//		return res.getList();
//	}
}