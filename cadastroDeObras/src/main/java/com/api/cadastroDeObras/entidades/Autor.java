package com.api.cadastroDeObras.entidades;

import java.time.LocalDate;
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
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_autor")
    private Long codigoAutor;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "sexo")
    private String sexo;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    
    @Column(name = "cpf")
    private String cpf;
    
    @ManyToOne
    @JoinColumn(name = "codigo_pais_FK", referencedColumnName = "codigo_pais")
    private Pais nacionalidade;

    public Long getCodigoAutor() {
        return codigoAutor;
    }

    public void setCodigoAutor(Long codigoAutor) {
        this.codigoAutor = codigoAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Pais getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(Pais nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.codigoAutor);
        hash = 23 * hash + Objects.hashCode(this.nome);
        hash = 23 * hash + Objects.hashCode(this.sexo);
        hash = 23 * hash + Objects.hashCode(this.email);
        hash = 23 * hash + Objects.hashCode(this.dataNascimento);
        hash = 23 * hash + Objects.hashCode(this.nacionalidade);
        hash = 23 * hash + Objects.hashCode(this.cpf);
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
        final Autor other = (Autor) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.nacionalidade, other.nacionalidade)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.codigoAutor, other.codigoAutor)) {
            return false;
        }
        return Objects.equals(this.dataNascimento, other.dataNascimento);
    }
}
