package com.api.cadastroDeObras.controlador;

import com.api.cadastroDeObras.entidades.Autor;
import com.api.cadastroDeObras.servico.AutorServico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autor")
public class AutorControlador {

    @Autowired
    private AutorServico autorServico;
    
    @GetMapping
    public List<Autor> listarAutor(){
        return autorServico.listarAutor();
    }
            
}
