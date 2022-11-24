package com.unijorge.projeto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unijorge.projeto.entidades.Projeto;

public interface ProjetoRepositorio extends JpaRepository<Projeto, Long> {
}