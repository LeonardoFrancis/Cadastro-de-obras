package com.api.cadastroDeObras.controlador;

import com.api.cadastroDeObras.dto.AutorRequestDto;
import com.api.cadastroDeObras.dto.AutorResponseDto;
import com.api.cadastroDeObras.entidades.Autor;
import com.api.cadastroDeObras.servico.AutorServico;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autor")
public class AutorControlador {

    @Autowired
    private AutorServico autorServico;
    
    @GetMapping
    public List<AutorResponseDto> listarAutor(){
        return autorServico.listarAutor();
    }
      
    @GetMapping("/{codigo}")
    public List<AutorResponseDto> listarAutorPorCodigo(@PathVariable Long codigo) {
        return autorServico.listarAutorPorCodigo(codigo);
    }
    
    @PostMapping
    public ResponseEntity<AutorResponseDto> cadastrarAutor(@RequestBody AutorRequestDto autorRequestDto) {
        Autor autorCadastrado = autorServico.cadastrarAutor(autorServico.converterAutorRequestDtoParaEntidade(autorRequestDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(autorServico.converterParaAutorResponseDto(autorCadastrado));
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{codigo}")
    public void deletarAutor(@PathVariable Long codigo) {
        autorServico.deletarAutor(codigo);
    }
    
    @PutMapping("/{codigo}")
    public ResponseEntity<Autor> atualizarAutor(@PathVariable Long codigo, @RequestBody Autor autor) {
        return ResponseEntity.status(HttpStatus.OK).body(autorServico.atualizarAutor(codigo, autor));
    }
}
