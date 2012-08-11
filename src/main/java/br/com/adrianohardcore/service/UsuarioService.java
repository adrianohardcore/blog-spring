package br.com.adrianohardcore.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.adrianohardcore.model.Usuario;
import br.com.adrianohardcore.repository.UsuarioRepository;

@Service
public class UsuarioService {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(UsuarioService.class);

	@Autowired
	private UsuarioRepository repository;

	@Transactional
	public Usuario salvar(Usuario usuario) {
		LOGGER.debug("Criando novo usuário: " + usuario);
		return repository.save(usuario);
//		try {
//			return repository.save(usuario);
//			
//		} catch (DataIntegrityViolationException e) {
//			System.out.println("**************************************************");
//			System.out.println(e);
//			System.out.println("**************************************************");
//			return null;
//		}  
			
	}

	@Transactional
	public void deletar(Usuario usuario) {
		LOGGER.debug("Apagando usuário: " + usuario);
		repository.delete(usuario);
	}

}
