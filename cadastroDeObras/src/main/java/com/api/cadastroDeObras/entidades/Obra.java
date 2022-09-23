package com.api.cadastroDeObras.entidades;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "obra")
public class Obra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_obra")
    private Long codigoObra;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "data_publicacao")
    private String dataPublicacao;
    
    @Column(name = "data_exposicao")
    private String dataExposicao;
    
    @ManyToOne
    @JoinColumn(name = "codigo_autor_FK", referencedColumnName = "codigo_autor")
    private Autor autor;
    
    public Long getCodigoObra() {
        return codigoObra;
    }

    public void setCodigoObra(Long codigoObra) {
        this.codigoObra = codigoObra;
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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.codigoObra);
        hash = 41 * hash + Objects.hashCode(this.nome);
        hash = 41 * hash + Objects.hashCode(this.descricao);
        hash = 41 * hash + Objects.hashCode(this.dataPublicacao);
        hash = 41 * hash + Objects.hashCode(this.dataExposicao);
        hash = 41 * hash + Objects.hashCode(this.autor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Obra other = (Obra) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.dataPublicacao, other.dataPublicacao)) {
            return false;
        }
        if (!Objects.equals(this.dataExposicao, other.dataExposicao)) {
            return false;
        }
        if (!Objects.equals(this.codigoObra, other.codigoObra)) {
            return false;
        }
        return Objects.equals(this.autor, other.autor);
    }
}
