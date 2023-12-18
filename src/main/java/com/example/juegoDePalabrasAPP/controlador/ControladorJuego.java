package com.example.juegoDePalabrasAPP.controlador;

import com.example.juegoDePalabrasAPP.repositorio.RepositorioJuego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/juego")
public class ControladorJuego {

    private final RepositorioJuego repositorioJuego;

    @Autowired
    public ControladorJuego( RepositorioJuego repositorioJuego){

        this.repositorioJuego = repositorioJuego;
    }

}
