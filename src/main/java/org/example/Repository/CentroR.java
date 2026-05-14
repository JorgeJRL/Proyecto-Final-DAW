package org.example.Repository;

import org.example.Model.Centro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentroR extends JpaRepository<Centro, Integer> {
}
