package br.com.adrianohardcore.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.adrianohardcore.model.Usuario;
import br.com.adrianohardcore.repository.RegraRepository;
import br.com.adrianohardcore.repository.UsuarioRepository;
import br.com.adrianohardcore.service.UsuarioService;

@Controller
public class UsuarioController {

	@Resource
	private UsuarioService usuarioService;

	@Resource
	private UsuarioRepository usuarioRepository;

	@Resource
	private RegraRepository regraRepository;

	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String cadastro(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuario/cadastro";
	}

	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public String list(ModelMap modelMap) {
		modelMap.addAttribute("usuarios", usuarioRepository.findAll());		
		return "usuario/listagem";
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public String cadastrar(@Valid Usuario usuario, BindingResult result,
			ModelMap modelMap) {

		if (result.hasErrors())
			return "usuario/cadastro";

		if (usuarioRepository.findByEmail(usuario.getEmail()) != null) {
			modelMap.addAttribute("mensagem", "Email já cadastrado!");
			return "usuario/cadastro";
		}
		if (usuarioRepository.findByNomeUsuario(usuario.getNomeUsuario()) != null) {
			modelMap.addAttribute("mensagem", "Nome de usuário indisponivel!");
			return "usuario/cadastro";
		}
		usuario.setRegra(regraRepository.findById((long)3));

		usuarioService.salvar(usuario);
		return "redirect:/usuarios";
	}

	@RequestMapping(value = "/usuario/{id}/editar", method = RequestMethod.GET)
	public String editar(@PathVariable("id") Long id, Model model,
			RedirectAttributes attributes, ModelMap modelMap) {
		Usuario usuario = usuarioRepository.findById(id);
		if (usuario == null) {
			modelMap.addAttribute("mensagem", "Usuário não cadastrado!");
			return "redirect:/usuarios";
		}
		modelMap.addAttribute("usuario", usuario);
		modelMap.addAttribute("regras", regraRepository.findAll());

		return "usuario/edicao";
	}

	@RequestMapping(value = "/usuario/atualiza", method = RequestMethod.POST)
	public String atualizar(@Valid Usuario usuario, BindingResult result,
			ModelMap modelMap) {
		
		
		System.out.println("############################################################################################");
		System.out.println(usuario.getRegra());
		System.out.println("############################################################################################");
		
		
		if (result.hasErrors())
			return "usuario/edicao";

		Usuario usuarioDb = usuarioRepository.findById(usuario.getId());
		usuarioDb.setNome(usuario.getNome());
		usuarioDb.setNomeUsuario(usuario.getNomeUsuario());
		usuarioDb.setSenha(usuario.getSenha());		
		usuarioDb.setRegra(usuario.getRegra());

		try {
			usuarioService.salvar(usuarioDb);
			return "redirect:/usuarios";
		} catch (Exception e) {
			modelMap.addAttribute("mensagem",
					"Não foi possivel atualizar o cadastro");
			return "redirect:/usuario/atualiza";
		}
	}

	@RequestMapping(value = "/usuario/{id}/exibir", method = RequestMethod.GET)
	public String exibir(@PathVariable("id") Long id, Model model,
			RedirectAttributes attributes, ModelMap modelMap) {
		Usuario usuario = usuarioRepository.findById(id);
		if (usuario == null) {
			modelMap.addAttribute("mensagem", "Usuário não cadastrado!");
			return "redirect:/usuarios";
		}
		modelMap.addAttribute("usuario", usuario);
		return "usuario/exibir";
	}

	@RequestMapping(value = "/usuario/{id}/deletar", method = RequestMethod.POST)
	public String delete(@PathVariable("id") Long id, ModelMap modelMap) {
		Usuario usuario = usuarioRepository.findById(id);
		if (usuario == null) {
			modelMap.addAttribute("mensagem", "Usuário não cadastrado!");
		}
		usuarioService.deletar(usuario);
		return "redirect:/usuarios";
	}
}
