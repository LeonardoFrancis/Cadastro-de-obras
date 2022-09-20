package com.api.cadastroDeObras.repositorio;

import com.api.cadastroDeObras.entidades.RelacaoObraEAutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelacaoObraEAutorRepositorio extends JpaRepository<RelacaoObraEAutor, Long>{
    
}
