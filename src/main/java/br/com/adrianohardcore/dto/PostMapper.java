package br.com.adrianohardcore.dto;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import br.com.adrianohardcore.model.Post;


public class PostMapper {
	public static PostDto map(Post post) {
		PostDto dto = new PostDto();
		dto.setId(post.getId());
		dto.setTitle(post.getTitle());
		dto.setBody(post.getBody());
		dto.setUsuarioCriacao(post.getUserCreation());
		dto.setDataCriacao(post.getDateCreation());	
		return dto;
}

public static List<PostDto> map(Page<Post> posts) {
	List<PostDto> dtos = new ArrayList<PostDto>();
	for (Post post: posts) {
		dtos.add(map(post));
	}
	return dtos;
}
}
	