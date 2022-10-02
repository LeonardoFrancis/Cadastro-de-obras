package com.api.cadastroDeObras.servico;

import com.api.cadastroDeObras.dto.AutorRequestDto;
import com.api.cadastroDeObras.dto.AutorResponseDto;
import com.api.cadastroDeObras.entidades.Autor;
import com.api.cadastroDeObras.entidades.Pais;
import com.api.cadastroDeObras.repositorio.AutorRepositorio;
import com.api.cadastroDeObras.repositorio.PaisRepositorio;
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
    private PaisRepositorio paisRepositorio;
    
    @Autowired
    private ModelMapper modelmapper;
    
    public List<AutorResponseDto> listarAutor() {
        return autorRepositorio.findAll()
                .stream().map(this::converterParaAutorResponseDto)
                .collect(Collectors.toList());
    }
    
    public AutorResponseDto listarAutorPorCodigo(Long codigoAutor) {
        Autor autor = validarExistenciaAutor(codigoAutor);
        return converterParaAutorResponseDto(autor);
    }
    
    public AutorResponseDto cadastrarAutor (AutorRequestDto autorRequestDto) {
        Pais pais = validarExistenciaPais(autorRequestDto.getNacionalidade().getNome());
        regraCpf(pais, autorRequestDto);
        autorRequestDto.setNacionalidade(pais);
        Autor autor = converterAutorRequestDtoParaEntidade(autorRequestDto);
        autorRepositorio.save(autor);
        return converterParaAutorResponseDto(autor);
    }
    
    public void deletarAutor (Long codigoAutor) {
        validarExistenciaAutor(codigoAutor);
        autorRepositorio.deleteById(codigoAutor);
    }
    
    public AutorResponseDto atualizarAutor (Long codigoAutor, AutorRequestDto autorRequestDto) {
        Pais pais = validarExistenciaPais(autorRequestDto.getNacionalidade().getNome());
        Autor autorAtualizado = validarExistenciaAutor(codigoAutor);
        autorRequestDto.setNacionalidade(pais);
        Autor autorConvertido = converterAutorRequestDtoParaEntidade(autorRequestDto);
        BeanUtils.copyProperties(autorConvertido, autorAtualizado, "codigoAutor");
        return converterParaAutorResponseDto(autorRepositorio.save(autorAtualizado));
    }
    
    public Autor validarExistenciaAutor (Long codigoAutor) {
        Optional<Autor> autor = autorRepositorio.findById(codigoAutor);
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
    
    public Pais validarExistenciaPais(String nomePais) {
        Optional<Pais> pais = paisRepositorio.findByNome(nomePais);
        if (pais.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        return pais.get();
    }
    // Método para obrigar a inserção do CPF no cadastro de autores brasileiros
    public void regraCpf(Pais pais, AutorRequestDto autorRequestDto) { 
        if((pais.getNome().equals("BRASIL")) && (autorRequestDto.getCpf() == null)) {
            throw new EmptyResultDataAccessException(1);
        }
    }
}
