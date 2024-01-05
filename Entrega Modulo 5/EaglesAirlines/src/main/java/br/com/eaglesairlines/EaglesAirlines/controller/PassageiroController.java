package br.com.eaglesairlines.EaglesAirlines.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.eaglesairlines.EaglesAirlines.model.Passageiros;
import br.com.eaglesairlines.EaglesAirlines.repository.PassageiroRepository;

@Controller
@RequestMapping("/passageiros")
public class PassageiroController {
	
	@Autowired
	private PassageiroRepository passageiroRepository;
	
	@GetMapping
	public ModelAndView passageiros() {
	    ModelAndView modelAndView = new ModelAndView("views/passageiros/index.html");
	    List<Passageiros> passageirosList = passageiroRepository.findAll();
	    modelAndView.addObject("passageiros", passageirosList);
	    modelAndView.addObject("passageiro", new Passageiros());
	    return modelAndView;
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(Passageiros passageiro) {
		passageiroRepository.save(passageiro);

		return "redirect:/passageiros";
	}

	@GetMapping("/{CPF}/excluir")
	public String excluir(@PathVariable String CPF) {
		passageiroRepository.deleteById(CPF);

		return "redirect:/passageiros";
	}

}
