package br.com.eaglesairlines.EaglesAirlines.controller;

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
		ModelAndView modelAndView = new ModelAndView("views/passagem/index.html");
		
		modelAndView.addObject("passagem", passagemRepository.getReferenceById(id_passagem));
		modelAndView.addObject("passagem", new Passagem());
		return modelAndView;
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(Passagem passagem) {
		passagemRepository.save(passagem);

		return "redirect:/passagem";
	}

	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id_passagem) {
		passagemRepository.deleteById(id_passagem);

		return "redirect:/passagem";
	}

}
