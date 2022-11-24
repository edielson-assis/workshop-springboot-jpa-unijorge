package com.unijorge.projeto.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.unijorge.projeto.entidades.Aluno;
import com.unijorge.projeto.entidades.Categoria;
import com.unijorge.projeto.entidades.Projeto;
import com.unijorge.projeto.repositorios.AlunoRepositorio;
import com.unijorge.projeto.repositorios.CategoriaRepositorio;
import com.unijorge.projeto.repositorios.ProjetoRepositorio;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

    @Autowired
    private AlunoRepositorio alunoRepositorio;

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Autowired
    private ProjetoRepositorio projetoRepositorio;

    @Override
    public void run(String... args) throws Exception {

        Aluno aluno1 = new Aluno("2200", "Edielson", "edielson@gmail.com", "300045862", "Salvador", "Bahia");
        Aluno aluno2 = new Aluno("3052", "Alan", "alan@gmail.com", "300044578", "Salvador", "Bahia");

        alunoRepositorio.saveAll(Arrays.asList(aluno1, aluno2));

        Categoria cat1 = new Categoria(null, "Computacao");
        Categoria cat2 = new Categoria(null, "Direito");

        Projeto p1 = new Projeto(null, "Startup", "Como criar uma startup?", aluno1);
        Projeto p2 = new Projeto(null, "Direito legal", "Tudo sobre direito", aluno2);
        Projeto p3 = new Projeto(null, "Java", "Aprenda java de forma pratica", aluno1);

        categoriaRepositorio.saveAll(Arrays.asList(cat1, cat2));
        projetoRepositorio.saveAll(Arrays.asList(p1, p2, p3));

        p1.getCategoria().add(cat2);
        p2.getCategoria().add(cat2);
        p3.getCategoria().add(cat1);

        projetoRepositorio.saveAll(Arrays.asList(p1, p2, p3)); 
    }
}