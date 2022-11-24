package com.unijorge.projeto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unijorge.projeto.entidades.Aluno;

public interface AlunoRepositorio extends JpaRepository<Aluno, String> {
}