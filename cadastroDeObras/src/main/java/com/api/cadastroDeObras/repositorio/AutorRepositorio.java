package com.api.cadastroDeObras.repositorio;

import com.api.cadastroDeObras.entidades.Autor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, Long>{
 
    public List<Autor> findByCodigo(Long codigo);
}
