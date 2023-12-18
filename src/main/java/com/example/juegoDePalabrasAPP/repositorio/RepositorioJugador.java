package com.example.juegoDePalabrasAPP.repositorio;

import com.example.juegoDePalabrasAPP.modelo.Equipo;
import com.example.juegoDePalabrasAPP.modelo.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositorioJugador extends JpaRepository<Jugador,Long> {
    List<Jugador> findAll();
    Optional<Jugador> findById(Long id);
    Jugador save(Jugador jugador);
    void deleteById(Long id);
    boolean existsById(Long id);
    List<Jugador> findByEquipo(Equipo equipo);
    List<Jugador> findByEquipoId(Long id_equipo);
    List<Jugador> obtenerJugadoresPorEquipo(Long id_equipo);
}