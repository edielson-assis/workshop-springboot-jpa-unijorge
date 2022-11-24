package com.unijorge.projeto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unijorge.projeto.entidades.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {
}