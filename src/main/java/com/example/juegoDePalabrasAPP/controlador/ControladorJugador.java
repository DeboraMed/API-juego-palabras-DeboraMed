package com.example.juegoDePalabrasAPP.controlador;

import com.example.juegoDePalabrasAPP.modelo.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.juegoDePalabrasAPP.repositorio.RepositorioJugador;

import java.util.List;

@RestController
@RequestMapping("/jugador")
public class ControladorJugador {

    private final RepositorioJugador repositorioJugador;

    @Autowired
    public ControladorJugador(RepositorioJugador repositorioJugador){
        this.repositorioJugador = repositorioJugador;
    }

    @GetMapping
    public ResponseEntity<List<Jugador>> getAll() {
        List<Jugador> jugadores = repositorioJugador.findAll();
        return new ResponseEntity<>(jugadores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jugador> getById(@PathVariable Long id){
        Jugador jugador = repositorioJugador.findById(id).orElseThrow(()-> new RuntimeException("Ha ocurrido una Excepcion"));
        return new ResponseEntity<>(jugador, HttpStatus.OK);
    }

}
