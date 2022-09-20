package com.api.cadastroDeObras.servico;

import com.api.cadastroDeObras.dto.AutorRequestDto;
import com.api.cadastroDeObras.dto.AutorResponseDto;
import com.api.cadastroDeObras.entidades.Autor;
import com.api.cadastroDeObras.repositorio.AutorRepositorio;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class AutorServico {

    @Autowired
    private AutorRepositorio autorRepositorio;
    
    @Autowired
    private ModelMapper modelmapper;
    
    public List<AutorResponseDto> listarAutor() {
        return autorRepositorio.findAll()
                .stream().map(this::converterParaAutorResponseDto)
                .collect(Collectors.toList());
    }
    
    public List<AutorResponseDto> listarAutorPorCodigo(Long codigo) {
        validarExistenciaAutor(codigo);
        return autorRepositorio.findByCodigo(codigo)
                .stream().map(this::converterParaAutorResponseDto)
                .collect(Collectors.toList());
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
        Optional<Autor> autor = autorRepositorio.findById(codigo);
        if (autor.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        return autor.get();
    }
    
    public AutorResponseDto converterParaAutorResponseDto(Autor autor) {
        return modelmapper.map(autor, AutorResponseDto.class);
    }
    
    public Autor converterAutorRequestDtoParaEntidade(AutorRequestDto autorRequestDto) {
        return modelmapper.map(autorRequestDto, Autor.class);
    }
}
