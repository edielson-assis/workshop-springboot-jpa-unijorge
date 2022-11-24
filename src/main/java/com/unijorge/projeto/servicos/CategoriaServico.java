package com.unijorge.projeto.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unijorge.projeto.entidades.Categoria;
import com.unijorge.projeto.repositorios.CategoriaRepositorio;

@Service
public class CategoriaServico {
    
    @Autowired
    private CategoriaRepositorio repositorio;

    public List<Categoria> encontrarTodos() {
        return repositorio.findAll();
    }

    public Categoria encontrarPorId(Long id) {
        Optional<Categoria> obj = repositorio.findById(id);
        return obj.get();
    }
}