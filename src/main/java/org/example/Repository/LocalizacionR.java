package org.example.Repository;

import org.example.Model.Localizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizacionR extends JpaRepository<Localizacion, Integer> {
}
