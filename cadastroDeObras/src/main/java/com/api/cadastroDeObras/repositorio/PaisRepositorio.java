package com.api.cadastroDeObras.repositorio;

import com.api.cadastroDeObras.entidades.Pais;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepositorio extends JpaRepository<Pais, Long> {
    
    Optional<Pais> findByNome(String nome);
}
