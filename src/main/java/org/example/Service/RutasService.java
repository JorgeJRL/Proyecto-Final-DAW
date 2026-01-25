package org.example.Service;

import jakarta.validation.Valid;
import org.example.Model.Rutas;
import org.example.Repository.RutasR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutasService {
    @Autowired
    RutasR rr;

    public List<Rutas> getRutas(){
        return rr.findAll();
    }

    public Rutas getRuta(int id) {
        return rr.findById(id).orElse(null);
    }

    public Rutas addRutas(@Valid Rutas ruta) {
        return rr.save(ruta);
    }

    public Rutas editRutas(@Valid Rutas ruta, int id) throws Exception{
        Rutas rutaAux = rr.findById(id).orElse(null);

        if(rutaAux != null){
            rutaAux.setNombre(ruta.getNombre());
            rutaAux.setHorarioLlegada(ruta.getHorarioLlegada());
            rutaAux.setHorarioSalida(ruta.getHorarioSalida());
            ruta.setEstado(ruta.isEstado());
            rr.save(rutaAux);
        }else throw new Exception("No existe esa ruta");

        return rutaAux;
    }

    public void removeRutas(int id) throws Exception{
        Rutas ruta = rr.findById(id).orElse(null);

        if(ruta != null){
            rr.delete(ruta);
        }else throw new Exception("No existe esa ruta");
    }

}
