package com.example.juegoDePalabrasAPP.controlador;

import com.example.juegoDePalabrasAPP.errores.JugadorNoEncontrado;
import com.example.juegoDePalabrasAPP.modelo.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.juegoDePalabrasAPP.repositorio.RepositorioJugador;

import java.time.LocalDateTime;
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
        if (jugadores.isEmpty()){
            throw new JugadorNoEncontrado();
        }
        return new ResponseEntity<>(jugadores, HttpStatus.OK);
    }

    // Buscar jugador
    @GetMapping("/{id}")
    public ResponseEntity<Jugador> getId_jugador(@PathVariable Long id){
        Jugador jugador = repositorioJugador.findById(id).orElseThrow(()-> new JugadorNoEncontrado(id));
        return new ResponseEntity<>(jugador, HttpStatus.OK);
    }

    // Crear jugador nuevo
    @PostMapping("/")
    public ResponseEntity<?> newJugador(@RequestBody Jugador nuevoJugador){
        Jugador newJugador = new Jugador();
        newJugador.setUsuario(nuevoJugador.getUsuario());
        newJugador.setPuntuacion(nuevoJugador.getPuntuacion());
        newJugador.setAvatar(nuevoJugador.getAvatar());
        newJugador.setFechaModificacion(LocalDateTime.now());
        newJugador.setCreationDate(LocalDateTime.now());
        newJugador.setEquipo(nuevoJugador.getEquipo());

        return ResponseEntity.status(HttpStatus.CREATED).body(repositorioJugador.save(nuevoJugador));
    }

    // Modificar jugador existente
    @PutMapping("/{id}")
    public Jugador updateJugador(@RequestBody Jugador actualizaJugador, @PathVariable Long id){
        if(repositorioJugador.existsById(id)){
            Jugador jugador = repositorioJugador.findById(id).get();
            jugador.setUsuario(actualizaJugador.getUsuario());
            jugador.setPuntuacion(actualizaJugador.getPuntuacion());
            jugador.setAvatar(actualizaJugador.getAvatar());
            jugador.setEquipo(actualizaJugador.getEquipo());
            jugador.setFechaModificacion(LocalDateTime.now());
            return repositorioJugador.save(jugador);
        } else {
            throw new JugadorNoEncontrado(id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        Jugador jugador = repositorioJugador.findById(id).orElseThrow(() -> new JugadorNoEncontrado(id));
        repositorioJugador.delete(jugador);
        return ResponseEntity.noContent().build();
    }



}
