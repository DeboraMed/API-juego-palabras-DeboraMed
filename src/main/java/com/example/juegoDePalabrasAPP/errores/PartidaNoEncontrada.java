package com.example.juegoDePalabrasAPP.errores;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PartidaNoEncontrada extends RuntimeException {
    public PartidaNoEncontrada(){
        super("ERROR: Las partidas no se encuentran.");
    }
    public PartidaNoEncontrada(Long id){
        super("ERROR: La partida con id:" + id +" no se encuentra.");
    }
}
