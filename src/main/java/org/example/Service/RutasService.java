package org.example.Service;

import jakarta.validation.Valid;
import org.example.Model.Rutas;
import org.example.Repository.RutasR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.dto.Rutas.*;

import java.util.List;

//Preguntarle a marcos si ponemos metodos void en actualizar y tal


@Service
public class RutasService {
    @Autowired
    RutasR rr;

    public List<RutasResponse> getRutas(){
        return rr.findAll().stream().map(this::toRutaResponseDTO).toList();
    }

    public RutasResponse getRuta(int id) {
        return toRutaResponseDTO(rr.findById(id).orElse(null));
    }

    public RutasResponse addRutas(@Valid RutasRequest rutasRequest) {
        Rutas ruta = new Rutas();
        ruta.setNombre(rutasRequest.nombre());
        ruta.setHorarioLlegada(rutasRequest.horarioLlegada());
        ruta.setHorarioSalida(rutasRequest.horarioSalida());
        ruta.setEstado(rutasRequest.estado());
        rr.save(ruta);

        return toRutaResponseDTO(ruta);
    }

    public RutasResponse editRutas(@Valid RutasRequest rutasRequest, int id) throws Exception{
        Rutas ruta = rr.findById(id).orElse(null);

        ruta.setNombre(rutasRequest.nombre());
        ruta.setHorarioLlegada(rutasRequest.horarioLlegada());
        ruta.setHorarioSalida(rutasRequest.horarioSalida());
        ruta.setEstado(rutasRequest.estado());
        rr.save(ruta);

        return toRutaResponseDTO(ruta);
    }

    public void removeRutas(int id) throws Exception{
        Rutas ruta = rr.findById(id).orElse(null);

        if(ruta != null){
            rr.delete(ruta);
        }else throw new Exception("No existe esa ruta");
    }
    private RutasResponse toRutaResponseDTO(Rutas ruta) {
        return new RutasResponse(
                ruta.getNombre(),
                ruta.getHorarioLlegada(),
                ruta.getHorarioSalida(),
                ruta.isEstado()
        );
    }
}
