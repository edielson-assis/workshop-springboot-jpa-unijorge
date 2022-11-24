package com.unijorge.projeto.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unijorge.projeto.entidades.Categoria;
import com.unijorge.projeto.servicos.CategoriaServico;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaControle {
    
    @Autowired
    private CategoriaServico servico;

    @GetMapping
    public ResponseEntity<List<Categoria>> encontrarTodos() {
        List<Categoria> list = servico.encontrarTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> encontrarPorId(@PathVariable Long id) {
        Categoria obj = servico.encontrarPorId(id);
        return ResponseEntity.ok().body(obj);
    }
}