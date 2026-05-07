package org.example.Repository;

import org.example.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleR extends JpaRepository<Role, Integer> {
    Optional<Role> findByRol(String rol);
}
