package com.api.cadastroDeObras.servico;

import com.api.cadastroDeObras.entidades.Autor;
import com.api.cadastroDeObras.entidades.Obra;
import com.api.cadastroDeObras.entidades.RelacaoObraEAutor;
import com.api.cadastroDeObras.repositorio.AutorRepositorio;
import com.api.cadastroDeObras.repositorio.ObraRepositorio;
import com.api.cadastroDeObras.repositorio.RelacaoObraEAutorRepositorio;
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
    @Autowired
    private AutorRepositorio autorRepositorio;
    @Autowired
    private RelacaoObraEAutorRepositorio relacaoObraEAutorRepositorio;
    
    private RelacaoObraEAutor relacaoObraEAutor = new RelacaoObraEAutor();
    
    public List<Obra> listarObraPorAutor(Long codigo) {
        autorServico.validarExistenciaAutor(codigo);
        return obraRepositorio.findByAutorCodigo(codigo);
    }
    
    public Optional<Obra> listarObraPorCodigo(Long codigo) {
        return obraRepositorio.findById(codigo);
    }
    
    public Obra cadastrarObra (Obra obra, Long autorCodigo) {
        Autor autorValidado = autorServico.validarExistenciaAutor(autorCodigo);
        obraRepositorio.save(obra);
        relacaoObraEAutor.setAutor(autorValidado);
        relacaoObraEAutor.setObra(obra);
        relacaoObraEAutorRepositorio.save(relacaoObraEAutor);
        return obra;
    }
}
