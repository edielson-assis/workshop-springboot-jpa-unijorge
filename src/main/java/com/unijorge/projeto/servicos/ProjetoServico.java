package com.unijorge.projeto.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unijorge.projeto.entidades.Projeto;
import com.unijorge.projeto.repositorios.ProjetoRepositorio;

@Service
public class ProjetoServico {
    
    @Autowired
    private ProjetoRepositorio repositorio;

    public List<Projeto> encontrarTodos() {
        return repositorio.findAll();
    }

    public Projeto encontrarPorId(Long id) {
        Optional<Projeto> obj = repositorio.findById(id);
        return obj.get();
    }
}