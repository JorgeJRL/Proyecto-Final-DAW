package org.example.Service;

import org.example.Model.Centro;
import org.example.Repository.CentroR;
import org.example.dto.Centro.CentroResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentroService {

    @Autowired
    CentroR cr;

    public List<CentroResponse> getAll (){
        return cr.findAll().stream().map(this::toCentroResponse).toList();
    }


    public CentroResponse toCentroResponse(Centro centro){

        return  new CentroResponse(
                centro.getNombre(),
                centro.getDireccion(),
                centro.getTelefono(),
                centro.getEmail(),
                centro.getTransportes()
        );
    }
}
