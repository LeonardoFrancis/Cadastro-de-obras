package com.api.cadastroDeObras.repositorio;

import com.api.cadastroDeObras.entidades.Obra;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraRepositorio extends JpaRepository<Obra, Long> {
    
    List<Obra> findByAutorCodigoAutor(Long codigoAutor);
}
