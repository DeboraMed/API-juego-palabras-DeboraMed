package com.example.juegoDePalabrasAPP.controlador;

import com.example.juegoDePalabrasAPP.errores.PartidaNoEncontrada;
import com.example.juegoDePalabrasAPP.modelo.Partida;
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

    @Autowired
    public ControladorPartida(RepositorioPartida repositorioPartida){ this.repositorioPartida = repositorioPartida; }

    @GetMapping
    public ResponseEntity<List<Partida>>getAll(){
        List<Partida> partidas = repositorioPartida.findAll();
        if (partidas.isEmpty()){
            throw new PartidaNoEncontrada();
        }
        return new ResponseEntity<>(partidas, HttpStatus.OK);
    }

    // Buscar partida
    @GetMapping("/{id}")
    public ResponseEntity<Partida> getById(@PathVariable Long id){
        Partida partida = repositorioPartida.findById(id).orElseThrow(()-> new RuntimeException("Ha ocurrido una Excepcion"));
        return new ResponseEntity<>(partida, HttpStatus.OK);
    }

    // Crear partida
    @PostMapping("/")
    public ResponseEntity<?> newPartida(@RequestBody Partida nuevaPartida) {
        Partida newPartida = new Partida();
        newPartida.setNum_intento(nuevaPartida.getNum_intento());
        newPartida.setPalabra_intento(nuevaPartida.getPalabra_intento());
        newPartida.setHora_comienzo(LocalDateTime.now());
        newPartida.setHora_final(LocalDateTime.now());
        newPartida.setPuntuacion(nuevaPartida.getPuntuacion());

        return ResponseEntity.status(HttpStatus.CREATED).body(repositorioPartida.save(newPartida));
    }


}
