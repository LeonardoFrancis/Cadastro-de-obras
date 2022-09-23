package com.api.cadastroDeObras.dto;

import com.api.cadastroDeObras.entidades.Autor;


public class ObraRequestDto {

    private String nome;
    
    private String descricao;
    
    private String dataPublicacao;
    
    private String dataExposicao;
    
    private Autor autor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getDataExposicao() {
        return dataExposicao;
    }

    public void setDataExposicao(String dataExposicao) {
        this.dataExposicao = dataExposicao;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
