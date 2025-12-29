package org.example.Model.Usuarios;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.Model.Role;

import java.util.Set;

@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_usuario")
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsers;

    @Column(name = "nombre")
    @NotNull(message = "El campo nickName no puede quedarse vacio")
    @Size(min=3)
    private String nombre;

    @Column(name="password", nullable = false)
    @NotBlank(message = "El campo password no puede quedarse vacio")
    @Size(min=5)
    private String password;

    @Column(name="email",nullable = false,unique = true)
    @NotBlank(message = "El campo email no puede quedar vacio")
    @Email
    private String email;

    @Column(name="apellidos", nullable = false)
    @NotBlank(message = "El campo apellidos no puede quedarse vacio")
    private String apellidos;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name= "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    //Utilizamos el Set para evitar duplicados
    private Set<Role> roles;

    public User() {
    }

    public User(String nombre, String password, String email, String apellidos, Set<Role> roles) {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.apellidos = apellidos;
        this.roles = roles;
    }

    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
