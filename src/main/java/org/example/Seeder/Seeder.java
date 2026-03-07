package org.example.Seeder;

import org.example.Model.Role;
import org.example.Model.Usuarios.Admin;
import org.example.Model.Usuarios.Alumno;
import org.example.Model.Usuarios.Familias;
import org.example.Repository.RoleR;
import org.example.Repository.Usuarios.UsuarioR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Set;

@Component
public class Seeder implements CommandLineRunner {

    @Autowired
    RoleR rr;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    private UsuarioR repo;

    @Override
    public void run(String... args) throws Exception {

        Role adminRole = rr.findByRol("ROLE_ADMIN")
                .orElseGet(() -> rr.save(new Role("ROLE_ADMIN")));

        Role familiaRole = rr.findByRol("ROLE_FAMILIA")
                .orElseGet(() -> rr.save(new Role("ROLE_FAMILIA")));

        Role alumnoRole = rr.findByRol("ROLE_ALUMNO")
                .orElseGet(() -> rr.save(new Role("ROLE_ALUMNO")));

        Set<Role> rolesAdmin = Set.of(adminRole, familiaRole, alumnoRole);
        Set<Role> rolesFammilia = Set.of(familiaRole);
        Set<Role> rolesAlumno = Set.of(alumnoRole);


        if (repo.findByNombre("admin").isEmpty()) {
            repo.save(new Admin(
                    "admin",
                    encoder.encode("admin1234"),
                    "admin@gmail.com",
                    "admin",
                    rolesAdmin
            ));
        }
        if (repo.findByNombre("alumno").isEmpty()) {
            repo.save(new Alumno(
                    "alumno",
                    encoder.encode("alumno1234"),
                    "alumno@gmail.com",
                    "alumno",
                    rolesAlumno,
                    "Segundo de Primaria",
                    "B"
            ));
        }
        if (repo.findByNombre("familia").isEmpty()) {
            repo.save(new Familias(
                    "familia",
                    encoder.encode("familia1234"),
                    "familia@gmail.com",
                    "familia",
                    rolesFammilia,
                    "si",
                    "23",
                    "asdads"
            ));
        }
    }
}
