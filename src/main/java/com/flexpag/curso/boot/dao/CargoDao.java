package com.flexpag.curso.boot.dao;

import java.util.List;

import com.flexpag.curso.boot.domain.Cargo;

public interface CargoDao {
	void save(Cargo cargo);
	
	void update(Cargo cargo);
	
	void delete(Long id);
	
	Cargo findById(Long id);
	
	List<Cargo> findAll();
}
