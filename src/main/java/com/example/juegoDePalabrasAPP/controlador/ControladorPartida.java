package com.example.juegoDePalabrasAPP.controlador;

import com.example.juegoDePalabrasAPP.errores.JugadorNoEncontrado;
import com.example.juegoDePalabrasAPP.errores.PartidaNoEncontrada;
import com.example.juegoDePalabrasAPP.modelo.Juego;
import com.example.juegoDePalabrasAPP.modelo.Jugador;
import com.example.juegoDePalabrasAPP.modelo.Partida;
import com.example.juegoDePalabrasAPP.repositorio.RepositorioJugador;
import com.example.juegoDePalabrasAPP.repositorio.RepositorioPartida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/partida")
public class ControladorPartida {

    private final RepositorioPartida repositorioPartida;
    private final RepositorioJugador repositorioJugador;
    //private final RepositorioJuego repositorioJuego;

    @Autowired
    public ControladorPartida(RepositorioPartida repositorioPartida, RepositorioJugador repositorioJugador){
        this.repositorioPartida = repositorioPartida;
        this.repositorioJugador = repositorioJugador;
    }

    @GetMapping
    public ResponseEntity<List<Partida>>getAll(){
        List<Partida> partidas = repositorioPartida.findAll();
        if (partidas.isEmpty()){
            throw new PartidaNoEncontrada();
        }
        return new ResponseEntity<>(partidas, HttpStatus.OK);
    }

    // Buscar partida por id partida
    @GetMapping("/{id}")
    public ResponseEntity<Partida> getById(@PathVariable Long id){
        Partida partida = repositorioPartida.findById(id).orElseThrow(()-> new RuntimeException("Ha ocurrido una Excepcion"));
        return new ResponseEntity<>(partida, HttpStatus.OK);
    }

    // TODO: Crear partida (despues de los DTO)
    @PostMapping("/")
    public ResponseEntity<?> newPartida(@RequestBody Partida nuevaPartida) {
        //Jugador jugador = repositorioJugador.findById(nuevaPartida.getJugadorId()).orElseThrow(()-> new JugadorNoEncontrado();
        //Juego juego = repositorioJuego.findById(nuevaPartida.getJuegoId()).orElseThrow(()-> new JuegoNoEncontrado(nuevaPartida.getJuegoId()));

        Partida newPartida = new Partida();
        newPartida.setNum_intento(nuevaPartida.getNum_intento());
        newPartida.setPalabra_intento(nuevaPartida.getPalabra_intento());
        newPartida.setHora_comienzo(LocalDateTime.now());
        newPartida.setHora_final(LocalDateTime.now());
        newPartida.setPuntuacion(nuevaPartida.getPuntuacion());
        //newPartida.setId_jugador(jugador);
        //newPartida.setId_juego(juego);

        return ResponseEntity.status(HttpStatus.CREATED).body(repositorioPartida.save(newPartida));
    }


}
