package br.com.adrianohardcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.adrianohardcore.model.Regra;

public interface RegraRepository extends JpaRepository<Regra, Long>{

	Regra findByRegra(String regra);

	Regra findById(Long id);  



}
