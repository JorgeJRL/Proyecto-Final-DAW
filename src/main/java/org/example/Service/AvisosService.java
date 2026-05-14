package org.example.Service;

import org.example.Model.Avisos;
import org.example.Model.Centro;
import org.example.Model.Rutas;
import org.example.Model.Usuarios.Admin;
import org.example.Model.Usuarios.Alumno;
import org.example.Model.Usuarios.Familias;
import org.example.Model.Usuarios.User;
import org.example.Repository.AvisosR;
import org.example.Repository.CentroR;
import org.example.Repository.RutasR;
import org.example.Repository.Usuarios.AdminR;
import org.example.Repository.Usuarios.UsuarioR;
import org.example.dto.Avisos.AvisoRequestDTO;
import org.example.dto.Avisos.AvisoResponseDTO;
import org.example.dto.Centro.CentroResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AvisosService {

    @Autowired
    AvisosR ar;

    @Autowired
    RutasR rr;

    @Autowired
    UsuarioR ur;

    @Autowired
    AdminR adminr;

    public List<AvisoResponseDTO> getAll (){
        return ar.findAll().stream().map(this::toAvisoResponse).toList();
    }

    // CREAR AVISO
    public AvisoResponseDTO crearAviso(AvisoRequestDTO dto) {
        Rutas ruta = rr.findById(dto.idRuta())
                .orElseThrow(() -> new RuntimeException("Ruta no encontrada"));

        Admin admin = adminr.findById(dto.idAdmin())
                .orElseThrow(() -> new RuntimeException("Admin no encontrado"));

        Avisos aviso = new Avisos(
                dto.mensaje(),
                dto.gravedad(),
                dto.fechaHora(),
                dto.tipo(),
                ruta,
                admin
        );

        return toAvisoResponse(ar.save(aviso));
    }

    // MODIFICAR AVISO
    public AvisoResponseDTO modificarAviso(int idAviso, AvisoRequestDTO dto) {
        Avisos aviso = ar.findById(idAviso)
                .orElseThrow(() -> new RuntimeException("Aviso no encontrado"));

        aviso.setMensaje(dto.mensaje());
        aviso.setGravedad(dto.gravedad());
        aviso.setTipo(dto.tipo());
        aviso.setFechaHora(dto.fechaHora());

        return toAvisoResponse(ar.save(aviso));
    }

    // BORRAR AVISO
    public void borrarAviso(int idAviso) {
        if (!ar.existsById(idAviso)) {
            throw new RuntimeException("Aviso no encontrado");
        }
        ar.deleteById(idAviso);
    }

    //EnviarAviso
    public List<AvisoResponseDTO> getAvisosByUsuario(int idUsuario) {
        User usuario = ur.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        final List<Rutas> rutas= new ArrayList<>();

        if (usuario instanceof Alumno alumno) {
            rutas.addAll(alumno.getRutasFavoritas());
        } else if (usuario instanceof Familias familia) {
            // Recoge las rutas favoritas de todos sus hijos
            for (Alumno hijo : familia.getAlumnos()) {
                rutas.addAll(hijo.getRutasFavoritas());
            }
        } else {
            throw new RuntimeException("Tipo de usuario no soportado");
        }

        return ar.findAll().stream()
                .filter(aviso -> rutas.contains(aviso.getRuta()))
                .map(this::toAvisoResponse)
                .toList();
    }


    public AvisoResponseDTO toAvisoResponse(Avisos avisos){

        return  new AvisoResponseDTO(
                avisos.getMensaje(),
                avisos.getGravedad(),
                avisos.getTipo(),
                avisos.getFechaHora(),
                avisos.getRuta().getNombre(),
                avisos.getAdmin().getNombre()
        );
    }
}
