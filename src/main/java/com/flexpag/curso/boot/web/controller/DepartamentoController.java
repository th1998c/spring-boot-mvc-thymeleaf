package com.flexpag.curso.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PostMapping("/salvar")
	public String salvar(Departamento departamento) {
		 departamentoService.salvar(departamento);
		 return "redirect:/departamentos/cadastrar";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("departamentos", departamentoService.buscarTodos());
		return "/departamento/lista";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable Long id, ModelMap model) {
		model.addAttribute("departamento", departamentoService.buscarPorId(id));
		return "/departamento/cadastrar";
	}
	
	@PostMapping("/editar")
	public String editar(Departamento departamento) {
		departamentoService.editar(departamento);
		return "redirect:/departamentos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String deletar(@PathVariable Long id, ModelMap model) {
		if(!departamentoService.departamentoTemCargos(id)) {
			departamentoService.excluir(id);
		}
		return listar(model);
	}
}
