package com.flexpag.curso.boot.dao;

import java.util.List;

import com.flexpag.curso.boot.domain.Funcionario;

public interface FuncionarioDao {
	void save(Funcionario funcionario);
	
	void update(Funcionario funcionario);
	
	void delete(Long id);
	
	Funcionario findById(Long id);
	
	List<Funcionario> findAll();
}
