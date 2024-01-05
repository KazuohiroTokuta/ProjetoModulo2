package br.com.eaglesairlines.EaglesAirlines.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import br.com.eaglesairlines.EaglesAirlines.model.Pedidos;
import br.com.eaglesairlines.EaglesAirlines.repository.PedidoRepository;
import br.com.eaglesairlines.EaglesAirlines.repository.PassageiroRepository;


@Controller
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private PassageiroRepository passageiroRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public ModelAndView pedidos() {
		ModelAndView modelAndView = new ModelAndView("views/pedidos/index.html");

		modelAndView.addObject("listaPassageiros", passageiroRepository.findAll());
		modelAndView.addObject("pedidos", pedidoRepository.findAll());
		modelAndView.addObject("pedidos", new Pedidos());

		return modelAndView;
	}
	
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long num_pedido) {
		pedidoRepository.deleteById(num_pedido);

		return "redirect:/pedidos";
	}

}
