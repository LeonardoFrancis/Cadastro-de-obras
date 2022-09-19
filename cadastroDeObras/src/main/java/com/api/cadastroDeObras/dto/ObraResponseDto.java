package com.api.cadastroDeObras.dto;


public class ObraResponseDto {

    private Long codigo;
    
    private String nome;
    
    private String descricao;
    
    private String dataPublicacao;
    
    private String dataExposicao;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

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
}
