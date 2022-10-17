package com.flexpag.curso.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.flexpag.curso.boot.domain.Cargo;
import com.flexpag.curso.boot.service.CargoService;
import com.flexpag.curso.boot.service.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {
    
    @Autowired
    private CargoService cargoService;
    @Autowired
    private DepartamentoService departamentoService;
    
    
	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo, ModelMap model) {
	    model.addAttribute("departamentos", departamentoService.buscarTodos());
		return "/cargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar() {
		return "/cargo/lista";
	}
	
    @PostMapping("/salvar")
    public String salvar(Cargo cargo, RedirectAttributes attr) {
         cargoService.salvar(cargo);
         attr.addFlashAttribute("success", "Cargo criado com sucesso.");
         return "redirect:/cargos/cadastrar";
    }
	
}
