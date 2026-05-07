package org.example.Seeder;

import org.example.Model.Centro;
import org.example.Model.Role;
import org.example.Model.Usuarios.Admin;
import org.example.Model.Usuarios.Alumno;
import org.example.Model.Usuarios.Familias;
import org.example.Repository.CentroR;
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

    @Autowired
    private CentroR cr;

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
        Centro centro = cr.save(new Centro(
                "Instituto 1",
                "Santa Cruz",
                956234565,
                "instituto@gmail.com",
                new ArrayList<>(),
                new ArrayList<>()
        ));
        if (repo.findByNombre("admin").isEmpty()) {
            repo.save(new Admin(
                    "admin",
                    encoder.encode("admin1234"),
                    "admin@gmail.com",
                    "admin",
                    rolesAdmin,
                    centro
            ));
        }
        Familias familia = null;
        if (repo.findByNombre("familia").isEmpty()) {
            familia = repo.save(new Familias(
                    "familia",
                    encoder.encode("familia1234"),
                    "familia@gmail.com",
                    "familia",
                    rolesFammilia,
                    "si",
                    "23",
                    "asdads"
            ));
        } else {
            familia = (Familias) repo.findByNombre("familia").get(); // <-- recuperas si ya existe
        }

        if (repo.findByNombre("alumno").isEmpty()) {
            repo.save(new Alumno(
                    "alumno",
                    encoder.encode("alumno1234"),
                    "alumno@gmail.com",
                    "alumno",
                    rolesAlumno,
                    "Segundo de Primaria",
                    "B",
                    centro,
                    familia,
                    null,
                    new ArrayList<>()
            ));
        }
        if (repo.findByNombre("alumno2").isEmpty()) {
            repo.save(new Alumno(
                    "alumno2",
                    encoder.encode("alumno1234"),
                    "alumno2@gmail.com",
                    "alumno2",
                    rolesAlumno,
                    "Cuarto de Primaria",
                    "A",
                    centro,
                    familia,
                    null,
                    new ArrayList<>()
            ));
        }
    }
}
