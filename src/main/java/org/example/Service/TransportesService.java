package org.example.Service;

import org.example.Model.Paradas;
import org.example.Model.RegistroViaje;
import org.example.Model.Transportes;
import org.example.Model.Usuarios.Alumno;
import org.example.Repository.ParadasR;
import org.example.Repository.RegistroViajeR;
import org.example.Repository.TransportesR;
import org.example.Repository.Usuarios.UsuarioR;
import org.example.dto.RegistroViaje.RVResponse;
import org.example.dto.Transportes.TransportesRequest;
import org.example.dto.Transportes.TransportesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransportesService {

    @Autowired
    private TransportesR tr;

    @Autowired
    private UsuarioR ur;

    @Autowired
    private ParadasR pr;

    @Autowired
    private RegistroViajeR rvr;

    //Ver
    public List<TransportesResponse> getAll(String tipo) {
        return tr.findByTipo(tipo).stream().map(this::toTransporteResponse).toList();
    }

    // CREAR
    public TransportesResponse crearTransporte(TransportesRequest dto) {
        Transportes transporte = new Transportes(
                dto.matricula(),
                dto.tipo()
        );
        return toTransporteResponse(tr.save(transporte));
    }

    // ACTUALIZAR
    public TransportesResponse actualizarTransporte(int idTransporte, TransportesRequest dto) {
        Transportes transporte = tr.findById(idTransporte)
                .orElseThrow(() -> new RuntimeException("Transporte no encontrado"));

        transporte.setMatricula(dto.matricula());
        transporte.setTipo(dto.tipo());

        return toTransporteResponse(tr.save(transporte));
    }

    // BORRAR
    public void borrarTransporte(int idTransporte) {
        if (!tr.existsById(idTransporte)) {
            throw new RuntimeException("Transporte no encontrado");
        }
        tr.deleteById(idTransporte);
    }

    public void ticar(int idAlumno, int idTransporte, int idParada) {
        Alumno alumno = (Alumno) ur.findById(idAlumno)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        Transportes transporte = tr.findById(idTransporte)
                .orElseThrow(() -> new RuntimeException("Transporte no encontrado"));

        Paradas parada = pr.findById(idParada)
                .orElseThrow(() -> new RuntimeException("Parada no encontrada"));

        // Desactiva el registro activo anterior si existe
        rvr.findByAlumnoAndActivoTrue(alumno)
                .ifPresent(r -> {
                    r.setActivo(false);
                    rvr.save(r);
                });

        // Crea el nuevo registro
        RegistroViaje registro = new RegistroViaje(
                alumno,
                transporte,
                parada,
                LocalDateTime.now(),
                true
        );

        rvr.save(registro);
    }

    public List<RVResponse> getHistorialAlumno(int idAlumno) {
        Alumno alumno = (Alumno) ur.findById(idAlumno)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        return rvr.findByAlumno(alumno).stream()
                .map(this::toRegistroViajeResponse)
                .toList();
    }


    public RVResponse toRegistroViajeResponse(RegistroViaje rv) {
        return new RVResponse(
                rv.getAlumno().getNombre(),
                rv.getTransporte().getMatricula(),
                rv.getFechaHora(),
                rv.isActivo()
        );
    }


    public TransportesResponse toTransporteResponse(Transportes transportes){

        return  new TransportesResponse(
                transportes.getMatricula(),
                transportes.getTipo()
        );
    }
}
