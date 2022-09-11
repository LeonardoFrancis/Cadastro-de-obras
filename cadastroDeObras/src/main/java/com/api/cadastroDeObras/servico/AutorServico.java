package com.api.cadastroDeObras.servico;

import com.api.cadastroDeObras.entidades.Autor;
import com.api.cadastroDeObras.repositorio.AutorRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServico {

    @Autowired
    private AutorRepositorio autorRepositorio;
    
    public List<Autor> listarAutor(){
        return autorRepositorio.findAll();
    }
}
