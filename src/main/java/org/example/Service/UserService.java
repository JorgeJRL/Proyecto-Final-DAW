package org.example.Service;

import org.example.Model.Paradas;
import org.example.Model.Role;
import org.example.Model.Rutas;
import org.example.Model.Usuarios.Alumno;
import org.example.Model.Usuarios.Familias;
import org.example.Model.Usuarios.User;
import org.example.Repository.ParadasR;
import org.example.Repository.RegistroViajeR;
import org.example.Repository.RutasR;
import org.example.Repository.Usuarios.AlumnoR;
import org.example.Repository.Usuarios.FamiliaR;
import org.example.Repository.Usuarios.UsuarioR;
import org.example.dto.Rutas.RutasResponse;
import org.example.dto.User.Alumno.AlumnoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private AlumnoR ar;

    @Autowired
    private FamiliaR fr;

    @Autowired
    private RutasR rr;

    @Autowired
    private ParadasR pr;

    @Autowired
    private RegistroViajeR rvr;

    private final UsuarioR repo;

    public UserService(UsuarioR repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = repo.findByNombre(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return new org.springframework.security.core.userdetails.User(
                user.getNombre(),
                user.getPassword(),
                user.getRoles().stream()
                        .map(Role::getRol)
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toSet())
        );
    }

    public List<AlumnoResponse> verTotalAlumnos(int idCentro){

        return ar.findByCentroIdCentro(idCentro)
                .stream()
                .map(this::toAlumnoResponse).toList();
    }
    public List<AlumnoResponse> verAlumnosByParada(int idParada){

        Paradas parada = pr.findById(idParada)
                .orElseThrow(() -> new RuntimeException("Parada no encontrada"));

        return rvr.findByParadaAndActivoTrue(parada).stream()
                .map(rv -> toAlumnoResponse(rv.getAlumno()))
                .toList();
    }



    // Añadir favorita
    public void anadirRutaFavorita(int idAlumno, int idRuta) {
        Alumno alumno = ar.findById(idAlumno)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        Rutas ruta = rr.findById(idRuta).orElseThrow(() -> new RuntimeException("Ruta no encontrado"));

        alumno.getRutasFavoritas().add(ruta);
        ar.save(alumno);
    }

    // Eliminar favorita
    public void eliminarRutaFavorita(int idAlumno, int idRuta) {
        Alumno alumno = ar.findById(idAlumno)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        Rutas ruta = rr.findById(idRuta).orElseThrow(() -> new RuntimeException("Ruta no encontrado"));

        alumno.getRutasFavoritas().remove(ruta);
        ar.save(alumno);
    }

    // Obtener favoritas
    public List<RutasResponse> getRutasFavoritas(int idAlumno) {
        return ar.findRutasFavoritasByAlumnoId(idAlumno)
                .orElse(Collections.emptyList())
                .stream()
                .map(this::toRutasResponse).toList();
    }

    public List<AlumnoResponse> getAlumnosAsociados(int idFamilia) {
        return fr.findById(idFamilia)
                .map(Familias::getAlumnos)
                .orElse(Collections.emptyList())
                .stream()
                .map(this::toAlumnoResponse)
                .collect(Collectors.toList());
    }


    public RutasResponse toRutasResponse(Rutas rutas){

        return  new RutasResponse(
                rutas.getNombre(),
                rutas.getHorarioSalida(),
                rutas.getHorarioLlegada(),
                rutas.isEstado()
        );
    }

    public AlumnoResponse toAlumnoResponse(Alumno alumno){

        return  new AlumnoResponse(
                alumno.getNombre(),
                alumno.getApellidos(),
                alumno.getEmail(),
                alumno.getCurso(),
                alumno.getGrupo(),
                alumno.getCentro().getNombre(),
                alumno.getTransportes() != null ? alumno.getTransportes().getTipo() : null
        );
    }
}
