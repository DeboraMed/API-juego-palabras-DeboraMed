package com.example.juegoDePalabrasAPP.errores;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class JugadorNoEncontrado extends RuntimeException {
    public JugadorNoEncontrado(){
        super("ERROR: Los jugadores no se encuantran.");
    }
    public JugadorNoEncontrado(Long id){
        super("ERROR: El jugador con id:" + id +" solicitado no se encuentra.");
    }
}
