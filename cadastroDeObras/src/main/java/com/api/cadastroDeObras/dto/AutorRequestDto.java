package com.api.cadastroDeObras.dto;

import com.api.cadastroDeObras.entidades.Pais;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;


public class AutorRequestDto {

    @NotBlank(message = "nome")
    private String nome;
    
    private String sexo;
    
    @Pattern(regexp = "^[A-Za-z0-9](([_.-]?[a-zA-Z0-9]+)*)@([A-Za-z0-9]+)(([.-]?[a-zA-Z0-9]+)*)([.][A-Za-z]{2,4})$")
    private String email;
    
    @NotNull(message = "data de nascimento")
    @Past(message = "data de nascimento")
    private LocalDate dataNascimento;
    
    @NotNull(message = "nacionalidade")
    private Pais nacionalidade;
    
    @Pattern(regexp = "[0-9]{3}[.][0-9]{3}[.][0-9]{3}[-][0-9]{2}", message = "CPF")
    private String cpf;

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
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Pais getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(Pais nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}
