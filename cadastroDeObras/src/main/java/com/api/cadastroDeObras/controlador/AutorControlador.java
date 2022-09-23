package com.api.cadastroDeObras.controlador;

import com.api.cadastroDeObras.dto.AutorRequestDto;
import com.api.cadastroDeObras.dto.AutorResponseDto;
import com.api.cadastroDeObras.servico.AutorServico;
import java.util.List;
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
      
    @GetMapping("/{codigoAutor}")
    public ResponseEntity<AutorResponseDto> listarAutorPorCodigo(@PathVariable Long codigoAutor) {
        return ResponseEntity.ok(autorServico.listarAutorPorCodigo(codigoAutor));
    }
    
    @PostMapping
    public ResponseEntity<AutorResponseDto> cadastrarAutor(@RequestBody AutorRequestDto autorRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(autorServico.cadastrarAutor(autorRequestDto));
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{codigoAutor}")
    public void deletarAutor(@PathVariable Long codigoAutor) {
        autorServico.deletarAutor(codigoAutor);
    }
    
    @PutMapping("/{codigoAutor}")
    public ResponseEntity<AutorResponseDto> atualizarAutor(@PathVariable Long codigoAutor, @RequestBody AutorRequestDto autorRequestDto) {
        return ResponseEntity.status(HttpStatus.OK).body(autorServico.atualizarAutor(codigoAutor, autorRequestDto));
    }
}
