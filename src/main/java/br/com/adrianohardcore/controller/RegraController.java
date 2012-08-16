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

import br.com.adrianohardcore.model.Regra;
import br.com.adrianohardcore.repository.RegraRepository;

@Controller
public class RegraController {
	@Resource
	RegraRepository regraRepository;

	@RequestMapping(value = "/regra/novo", method = RequestMethod.GET)
	public String cadastro(Model model) {
		model.addAttribute("regra", new Regra());
		return "regra/novo";
	}

	@RequestMapping(value = "/regra/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Regra regra, BindingResult result,
			ModelMap modelMap) {

		if (result.hasErrors())
			return "regra/novo";

		if (regraRepository.findByRegra(regra.getRegra()) != null) {
			modelMap.addAttribute("mensagem", "Regra já cadastrada!");
			return "usuario/cadastro";
		}

		regraRepository.save(regra);
		return "redirect:/regras";
	}

	@RequestMapping(value = "/regras", method = RequestMethod.GET)
	public String list(ModelMap modelMap) {
		modelMap.addAttribute("regras", regraRepository.findAll());
		return "regra/listagem";
	}

	@RequestMapping(value = "/regra/{id}/editar", method = RequestMethod.GET)
	public String editar(@PathVariable("id") Long id, Model model,
			RedirectAttributes attributes, ModelMap modelMap) {
		Regra regra = regraRepository.findById(id);
		if (regra == null) {
			modelMap.addAttribute("mensagem", "Regra não cadastrada!");
			return "redirect:/regras";
		}
		modelMap.addAttribute("regra", regra);
		return "regra/edicao";
	}
	
	@RequestMapping(value = "/regra/editar", method = RequestMethod.POST)
	public String atualizar(@Valid Regra regra, BindingResult result, ModelMap modelMap) {
		if (result.hasErrors())
			return "regra/edicao";
		
		Regra regraDb = regraRepository.findById(regra.getId());
		regraDb.setRegra(regra.getRegra());
		regraDb.setDescricao(regra.getDescricao());		
		
		try {
			regraRepository.save(regraDb);
			return "redirect:/regras";
		} catch (Exception e) {  
			modelMap.addAttribute("mensagem",
					"Não foi possivel atualizar o cadastro");
			return "forward:regra/editar";
		}
	}
	
	@RequestMapping(value = "/regra/{id}/deletar", method = RequestMethod.POST)
	public String delete(@PathVariable("id") Long id ,ModelMap modelMap) {
		Regra regra = regraRepository.findById(id);
		if (regra == null) {   
			modelMap.addAttribute("mensagem", "Regra não cadastrada!");			
		}	
		regraRepository.delete(regra);		
		return "redirect:/regras";
	}
	
	@RequestMapping(value = "/regra/{id}/exibir", method = RequestMethod.GET)
	public String exibir(@PathVariable("id") Long id, Model model,
			RedirectAttributes attributes, ModelMap modelMap) {
		Regra regra = regraRepository.findById(id);
		if (regra == null) {
			modelMap.addAttribute("mensagem", "Regra não cadastrada!");
			return "redirect:/regras";
		}
		modelMap.addAttribute("regra", regra);
		return "regra/exibir";
	}  
}
