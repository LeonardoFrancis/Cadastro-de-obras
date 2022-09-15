package com.api.cadastroDeObras.repositorio;

import com.api.cadastroDeObras.entidades.Obra;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObraRepositorio extends JpaRepository<Obra, Long> {
    
    List<Obra> findByAutorCodigo(Long autorCodigo);
}
