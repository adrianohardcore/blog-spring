package br.com.adrianohardcore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.adrianohardcore.model.Comment;
import br.com.adrianohardcore.model.Post;

public interface CommentRepository extends JpaRepository<Comment, Long> {	
	List<Comment> findByPost(Post post);
}
