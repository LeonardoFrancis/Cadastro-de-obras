package com.api.cadastroDeObras.servico;

import com.api.cadastroDeObras.entidades.Autor;
import com.api.cadastroDeObras.repositorio.AutorRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class AutorServico {

    @Autowired
    private AutorRepositorio autorRepositorio;
    
    public List<Autor> listarAutor() {
        return autorRepositorio.findAll();
    }
    
    public Optional<Autor> listarAutorPorCodigo(Long codigo) {
        return autorRepositorio.findById(codigo);
    }
    
    public Autor cadastrarAutor (Autor autor) {
        return autorRepositorio.save(autor);
    }
    
    public void deletarAutor (Long codigo) {
        autorRepositorio.deleteById(codigo);
    }
    
    public Autor atualizarAutor (Long codigo, Autor autor) {
        Autor autorAtualizado = validarExistenciaAutor(codigo);
        BeanUtils.copyProperties(autor, autorAtualizado, "codigo");
        return autorRepositorio.save(autorAtualizado);
    }
    
    public Autor validarExistenciaAutor (Long codigo) {
        Optional<Autor> autor = listarAutorPorCodigo(codigo);
        if (autor.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        return autor.get();
    }
}
