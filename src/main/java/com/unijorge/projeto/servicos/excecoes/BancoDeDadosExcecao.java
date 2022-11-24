package com.unijorge.projeto.servicos.excecoes;

public class BancoDeDadosExcecao extends RuntimeException {
    
    public BancoDeDadosExcecao(String msg) {
        super(msg);
    }
}