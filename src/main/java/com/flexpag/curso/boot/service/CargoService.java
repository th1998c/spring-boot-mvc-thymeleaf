package com.flexpag.curso.boot.service;

import java.util.List;

import com.flexpag.curso.boot.domain.Cargo;

public interface CargoService {
	void salvar(Cargo cargo);
	
	void editar(Cargo cargo);
	
	void excluir(Long id);
	
	Cargo buscarPorId(Long id);
	
	List<Cargo> buscarTodos();
}
