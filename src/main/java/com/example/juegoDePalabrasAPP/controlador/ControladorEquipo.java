package com.example.juegoDePalabrasAPP.controlador;

import com.example.juegoDePalabrasAPP.errores.EquipoNoEncontrado;
import com.example.juegoDePalabrasAPP.errores.JugadorNoEncontrado;
import com.example.juegoDePalabrasAPP.modelo.Equipo;
import com.example.juegoDePalabrasAPP.repositorio.RepositorioEquipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
        if (equipos.isEmpty()){
            throw new EquipoNoEncontrado();
        }
        return new ResponseEntity<>(equipos, HttpStatus.OK);
    }

    // Buscar equipo
    @GetMapping("/{id}")
    public ResponseEntity<Equipo> getById(@PathVariable Long id){
        Equipo equipo = repositorioEquipo.findById(id).orElseThrow(()-> new RuntimeException("Ha ocurrido una Excepcion"));
        return new ResponseEntity<>(equipo, HttpStatus.OK);
    }

    // Crear equipo
    @PostMapping("/")
    public ResponseEntity<?> newEquipo(@RequestBody Equipo nuevoEquipo) {
        Equipo newEquipo = new Equipo();
        newEquipo.setNombre_equipo(nuevoEquipo.getNombre_equipo());
        newEquipo.setEscudo(nuevoEquipo.getEscudo());
        newEquipo.setPuntuacion(nuevoEquipo.getPuntuacion());
        newEquipo.setFechaModificacion(LocalDateTime.now());
        newEquipo.setCreationDate(LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.CREATED).body(repositorioEquipo.save(newEquipo));
    }

    // Modificar equipo
    @PutMapping("/{id}")
    public Equipo updateEquipo(@RequestBody Equipo actualizaEquipo, @PathVariable Long id){
        if(repositorioEquipo.existsById(id)){
            Equipo equipo = repositorioEquipo.findById(id).get();
            equipo.setNombre_equipo(actualizaEquipo.getNombre_equipo());
            equipo.setEscudo(actualizaEquipo.getEscudo());
            equipo.setPuntuacion(actualizaEquipo.getPuntuacion());
            equipo.setFechaModificacion(LocalDateTime.now());

            return  repositorioEquipo.save(equipo);
        } else {
            throw new EquipoNoEncontrado(id);
        }
    }

    // Elimina equipo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        Equipo equipo = repositorioEquipo.findById(id).orElseThrow(()-> new JugadorNoEncontrado(id));
        repositorioEquipo.delete(equipo);
        return ResponseEntity.noContent().build();
    }
}

