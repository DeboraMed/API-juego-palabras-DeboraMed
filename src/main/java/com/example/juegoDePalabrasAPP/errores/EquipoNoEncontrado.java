package com.example.juegoDePalabrasAPP.errores;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EquipoNoEncontrado extends RuntimeException {

    public EquipoNoEncontrado(){
        super("ERROR: Los equipos no se encuentran");
    }
    public EquipoNoEncontrado(Long id){
        super("ERROR: El equipo con id"+ id + " no se encuentra");
    }
}
