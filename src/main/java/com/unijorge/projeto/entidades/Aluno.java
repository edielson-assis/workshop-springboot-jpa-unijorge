package com.unijorge.projeto.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_aluno")
public class Aluno implements Serializable {
    
    @Id
    private String matricula;
    private String nome;
    private String email;
    private String telefone;
    private String cidade;
    private String estado;

    @JsonIgnore
    @OneToMany(mappedBy = "aluno")
    final private List<Projeto> projetoDeAluno = new ArrayList<>();
}