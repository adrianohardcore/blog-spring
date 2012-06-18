package br.com.adrianohardcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.adrianohardcore.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
