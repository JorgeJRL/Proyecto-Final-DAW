package org.example;

import org.example.Model.Role;
import org.example.Model.Usuarios.Admin;
import org.example.Model.Usuarios.Alumno;
import org.example.Model.Usuarios.Familias;
import org.example.Repository.RoleR;
import org.example.Repository.UsuarioR;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {SpringApplication.run(Main.class, args);
//        String encodedPassword = encoder.encode("admin123");
//        String encodedPassword2 = encoder.encode("alumno123");
//        String encodedPassword3 = encoder.encode("familia123");
    }

    @Bean
    CommandLineRunner init(UsuarioR repo, RoleR rr, BCryptPasswordEncoder encoder) {

        //En el futuro se implementaran con ficheros, de momento es con datos de prueba
        return args -> {
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
        };
    }
}
