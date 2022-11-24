package com.unijorge.projeto.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unijorge.projeto.entidades.Projeto;
import com.unijorge.projeto.servicos.ProjetoServico;

@RestController
@RequestMapping(value = "/projetos")
public class ProjetoControle {
    
    @Autowired
    private ProjetoServico servico;

    @GetMapping
    public ResponseEntity<List<Projeto>> encontrarTodos() {
        List<Projeto> list = servico.encontrarTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Projeto> encontrarPorId(@PathVariable Long id) {
        Projeto obj = servico.encontrarPorId(id);
        return ResponseEntity.ok().body(obj);
    }
}