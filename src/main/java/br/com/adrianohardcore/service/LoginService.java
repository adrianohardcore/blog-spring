package br.com.adrianohardcore.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.hibernate.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.adrianohardcore.model.Usuario;
import br.com.adrianohardcore.repository.UsuarioRepository;

@SuppressWarnings("deprecation")
@Service
@Transactional(readOnly = true)
public class LoginService extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("deprecation")
	@Override
	protected UserDetails retrieveUser(String username,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {

		String password = (String) authentication.getCredentials();
		if (!StringUtils.hasText(password)) {
			throw new BadCredentialsException("Entre com a senha por favor");
		}

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		try {
			Usuario usuario = usuarioRepository.findByNomeUsuarioAndSenha(
					username, password);
			if (usuario != null) {
				authorities.add(new GrantedAuthorityImpl(usuario.getRegra()
						.toString()));
			} else {
				throw new BadCredentialsException("Usuário ou Senha inválido");
			}

		} catch (EmptyResultDataAccessException e) {
			throw new BadCredentialsException("Usuário ou Senha inválido");
		} catch (EntityNotFoundException e) {
			throw new BadCredentialsException("Usuário Inválido");
		} catch (NonUniqueResultException e) {
			throw new BadCredentialsException(
					"Usuário não é único,contacte o administrador");
		}

		return new User(username, password, true, true, true, true, authorities);

		// try {
		// Usuario usuario =
		// usuarioRepository.findByNomeUsuarioAndSenha(username, password);
		// System.out.println("###########################################################");
		// System.out.println(usuario.getRegra());
		// System.out.println("###########################################################");
		// //Cliente.findClientesByEmailAndSenhaEquals(username,
		// password).getSingleResult();
		// //authorities.add(new GrantedAuthorityImpl("ROLE_USER"));
		//
		// authorities.add(new
		// GrantedAuthorityImpl(usuario.getRegra().toString()));
		// } catch (EmptyResultDataAccessException e) {
		// throw new BadCredentialsException("Usuário ou Senha inválido");
		// } catch (EntityNotFoundException e) {
		// throw new BadCredentialsException("Usuário Inválido");
		// } catch (NonUniqueResultException e) {
		// throw new
		// BadCredentialsException("Usuário não é único,contacte o administrador");
		// }

		// return new User(username, password, true, true, true, true,
		// authorities);
	}
}