package com.flexpag.curso.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flexpag.curso.boot.domain.Departamento;
import com.flexpag.curso.boot.service.DepartamentoService;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService departamentoService;
		
	@GetMapping("/cadastrar")
	public String cadastrar(Departamento departamento) {
		return "/departamento/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("departamentos", departamentoService.buscarTodos());
		return "/departamento/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Departamento departamento) {
		 departamentoService.salvar(departamento);
		 return "redirect:/departamentos/cadastrar";
	}
}
