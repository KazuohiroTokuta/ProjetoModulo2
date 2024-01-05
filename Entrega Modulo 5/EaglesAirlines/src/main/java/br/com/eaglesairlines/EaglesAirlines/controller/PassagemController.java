package br.com.eaglesairlines.EaglesAirlines.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.eaglesairlines.EaglesAirlines.model.Passagem;
import br.com.eaglesairlines.EaglesAirlines.repository.PassagemRepository;

@Controller
@RequestMapping("/passagem")
public class PassagemController {
	
	@Autowired
	private PassagemRepository passagemRepository;
	
	@GetMapping
	public ModelAndView passagem(@PathVariable Long id_passagem) {
		ModelAndView modelAndView = new ModelAndView("views/passagens/index.html");
		List<Passagem> passagemList = passagemRepository.findAll();
		modelAndView.addObject("passagem", passagemList);
		modelAndView.addObject("passagem", new Passagem());
		return modelAndView;
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(Passagem passagem) {
		passagemRepository.save(passagem);

		return "redirect:/passagem";
	}

	@GetMapping("/{id_passagem}/excluir")
	public String excluir(@PathVariable Long id_passagem) {
		passagemRepository.deleteById(id_passagem);

		return "redirect:/passagem";
	}

}
