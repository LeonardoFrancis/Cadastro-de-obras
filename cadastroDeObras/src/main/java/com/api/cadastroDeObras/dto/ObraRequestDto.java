package com.api.cadastroDeObras.dto;

import com.api.cadastroDeObras.entidades.Autor;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;


public class ObraRequestDto {

    @NotBlank(message = "nome")
    private String nome;
    
    @NotBlank(message = "descrição")
    @Length(max = 240, message = "descrição")
    private String descricao;
    
    private LocalDate dataPublicacao;
    
    private LocalDate dataExposicao;
    
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

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public LocalDate getDataExposicao() {
        return dataExposicao;
    }

    public void setDataExposicao(LocalDate dataExposicao) {
        this.dataExposicao = dataExposicao;
    }
    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
