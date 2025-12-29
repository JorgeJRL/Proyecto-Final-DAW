package org.example.Repository;

import org.example.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleR extends JpaRepository<Role, Long> {
    Optional<Role> findByRol(String rol);
}
