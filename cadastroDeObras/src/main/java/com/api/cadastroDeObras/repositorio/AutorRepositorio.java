package com.api.cadastroDeObras.repositorio;

import com.api.cadastroDeObras.entidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepositorio extends JpaRepository<Autor, Long>{
    
}
