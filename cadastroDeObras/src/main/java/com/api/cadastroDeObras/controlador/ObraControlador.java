package com.api.cadastroDeObras.controlador;

import com.api.cadastroDeObras.entidades.Obra;
import com.api.cadastroDeObras.servico.ObraServico;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/obra")
public class ObraControlador {

    @Autowired
    private ObraServico obraServico;
    
    @GetMapping("/autor/{codigo}")
    public List<Obra> listarObraPorAutor(@PathVariable Long codigo) {
        return obraServico.listarObraPorAutor(codigo);
    }
    
    @GetMapping("/{codigo}")
    public Optional<Obra> listarObraPorCodigo(@PathVariable Long codigo) {
        return obraServico.listarObraPorCodigo(codigo);
    }
    
    @PostMapping("/{codigoAutor}")
    public Obra cadastrarObra(@PathVariable Long codigoAutor, @RequestBody Obra obra) {
        return obraServico.cadastrarObra(obra, codigoAutor);
    }
}
