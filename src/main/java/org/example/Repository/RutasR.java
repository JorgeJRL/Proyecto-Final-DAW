package org.example.Repository;

import org.example.Model.Rutas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RutasR extends JpaRepository<Rutas, Integer> {
}
