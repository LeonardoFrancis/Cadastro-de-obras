package com.api.cadastroDeObras.servico;

import com.api.cadastroDeObras.entidades.Autor;
import com.api.cadastroDeObras.entidades.Obra;
import com.api.cadastroDeObras.repositorio.ObraRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObraServico {
    
    @Autowired
    private ObraRepositorio obraRepositorio;
    @Autowired
    private AutorServico autorServico;
    
    public List<Obra> listarObraPorAutor(Long codigo) {
        autorServico.validarExistenciaAutor(codigo);
        return obraRepositorio.findByAutorCodigo(codigo);
    }
    
    public Optional<Obra> listarObraPorCodigo(Long codigo) {
        return obraRepositorio.findById(codigo);
    }
    
    public Obra cadastrarObra (Obra obra, Long codigoAutor) {
        autorServico.validarExistenciaAutor(codigoAutor);
        return obraRepositorio.save(obra);
    }
}
