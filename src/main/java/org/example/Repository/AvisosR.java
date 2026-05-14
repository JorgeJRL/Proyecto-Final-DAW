package org.example.Repository;

import org.example.Model.Avisos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvisosR extends JpaRepository<Avisos, Integer> {
}
