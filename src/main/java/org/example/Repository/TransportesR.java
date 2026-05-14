package org.example.Repository;

import org.example.Model.Transportes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TransportesR extends JpaRepository<Transportes, Integer> {
    // Métodos personalizados si es necesario
    Optional<Transportes> findByTipo(String tipo);
}
