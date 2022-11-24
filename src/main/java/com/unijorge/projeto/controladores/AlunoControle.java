package com.unijorge.projeto.controladores;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.unijorge.projeto.entidades.Aluno;
import com.unijorge.projeto.servicos.AlunoServico;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoControle { 
    
    @Autowired
    private AlunoServico servico;

    @GetMapping
    public ResponseEntity<List<Aluno>> encontrarTodos() {
        List<Aluno> list = servico.encontrarTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Aluno> encontrarPorId(@PathVariable String id) {
        Aluno obj = servico.encontrarPorId(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Aluno> inserir(@RequestBody Aluno obj) {
        obj = servico.inserir(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getMatricula()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        servico.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable String id, @RequestBody Aluno obj) {
        obj = servico.atualizar(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}