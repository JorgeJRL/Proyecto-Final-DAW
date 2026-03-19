package org.example.Service;

import jakarta.validation.Valid;
import org.example.Model.Paradas;
import org.example.Model.Rutas;
import org.example.Repository.ParadasR;
import org.example.Repository.RutasR;
import org.example.dto.Paradas.ParadasRequest;
import org.example.dto.Paradas.ParadasResponse;
import org.example.dto.Rutas.RutasResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParadasService {

    @Autowired
    ParadasR pr;
    @Autowired
    RutasR rr;

    public List<ParadasResponse> getParadas(){ return pr.findAll().stream().map(this::toParadasResponse).toList();}

    public ParadasResponse getParada(int id){return toParadasResponse(pr.findById(id).orElse(null));}

    public ParadasResponse addParada(@Valid ParadasRequest paradasRequest){
        Paradas parada = new Paradas();

        Rutas ruta = rr.findById(paradasRequest.ruta().getIdRuta()).orElse(null);

        parada.setNombreParada(paradasRequest.nombreParada());
        parada.setLatitud(paradasRequest.latitud());
        parada.setLongitud(paradasRequest.longitud());
        parada.setOrden(paradasRequest.orden());
        parada.setRuta(ruta);
        pr.save(parada);

        return toParadasResponse(parada);
    }

    public ParadasResponse editParadas(@Valid ParadasRequest paradasRequest, int id){
        Paradas parada = pr.findById(id).orElse(null);

        Rutas ruta = rr.findById(paradasRequest.ruta().getIdRuta()).orElse(null);

        parada.setNombreParada(paradasRequest.nombreParada());
        parada.setLatitud(paradasRequest.latitud());
        parada.setLongitud(paradasRequest.longitud());
        parada.setOrden(paradasRequest.orden());
        parada.setRuta(ruta);
        pr.save(parada);

        return toParadasResponse(parada);
    }

    public void removeParadas(int id) throws  Exception{
        Paradas parada = pr.findById(id).orElse(null);

        if(parada != null){
            pr.delete(parada);
        }else throw new Exception("No existe esa parada");
    }

    public ParadasResponse toParadasResponse(Paradas parada){
        return new ParadasResponse(
                parada.getNombreParada(),
                parada.getLatitud(),
                parada.getLongitud(),
                parada.getOrden(),
                parada.getRuta()
        );
    }

}
