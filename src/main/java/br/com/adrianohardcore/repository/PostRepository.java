package br.com.adrianohardcore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.adrianohardcore.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	//Page<Post> findByTitleLike(String title,Pageable pageable);

	//Page<Post> findByTitleLike(String searchTerm, int pageIndex);

	
	//postRepository.findByTitleLike(searchTerm, searchCriteria.getPageIndex());	
	
}
