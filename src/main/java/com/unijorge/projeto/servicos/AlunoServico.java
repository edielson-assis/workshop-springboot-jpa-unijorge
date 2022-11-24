package com.unijorge.projeto.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.unijorge.projeto.entidades.Aluno;
import com.unijorge.projeto.repositorios.AlunoRepositorio;
import com.unijorge.projeto.servicos.excecoes.BancoDeDadosExcecao;
import com.unijorge.projeto.servicos.excecoes.RecursoNaoEncontradoExcecao;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AlunoServico {
    
    @Autowired
    private AlunoRepositorio repositorio;

    public List<Aluno> encontrarTodos() {
        return repositorio.findAll();
    }

    public Aluno encontrarPorId(String id) {
        Optional<Aluno> obj = repositorio.findById(id);
        return obj.orElseThrow(() -> new RecursoNaoEncontradoExcecao(id));
    }

    public Aluno inserir(Aluno obj) {
        return repositorio.save(obj);
    }

    public void deletar(String id) {
        try {
            repositorio.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new RecursoNaoEncontradoExcecao(id);
        } 
        catch (DataIntegrityViolationException e) {
            throw new BancoDeDadosExcecao(e.getMessage());
        }
    }

    public Aluno atualizar(String id, Aluno obj) {
        try {
            Aluno entidade = repositorio.getReferenceById(id);
            atualizacaoDeDados(entidade, obj);
            return repositorio.save(entidade);
        }
        catch (EntityNotFoundException e) {
            throw new RecursoNaoEncontradoExcecao(id);
        }
    }

    private void atualizacaoDeDados(Aluno entidade, Aluno obj) {
        entidade.setNome(obj.getNome());
        entidade.setEmail(obj.getEmail());
        entidade.setTelefone(obj.getTelefone());
        entidade.setCidade(obj.getCidade());
        entidade.setEstado(obj.getEstado());
    }
}