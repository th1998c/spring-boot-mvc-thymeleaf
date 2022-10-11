package com.flexpag.curso.boot.dao;

import org.springframework.stereotype.Repository;

import com.flexpag.curso.boot.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

}
