package com.example.juegoDePalabrasAPP.controlador;

import com.example.juegoDePalabrasAPP.modelo.Equipo;
import com.example.juegoDePalabrasAPP.repositorio.RepositorioEquipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipo")
public class ControladorEquipo {

    private final RepositorioEquipo repositorioEquipo;

    @Autowired
    public ControladorEquipo(RepositorioEquipo repositorioEquipo){
        this.repositorioEquipo = repositorioEquipo;
    }

    @GetMapping
    public ResponseEntity<List<Equipo>>getAll(){
        List<Equipo> equipos = repositorioEquipo.findAll();
        return new ResponseEntity<>(equipos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> getById(@PathVariable Long id){
        Equipo equipo = repositorioEquipo.findById(id).orElseThrow(()-> new RuntimeException("Ha ocurrido una Excepcion"));
        return new ResponseEntity<>(equipo, HttpStatus.OK);
    }
}
