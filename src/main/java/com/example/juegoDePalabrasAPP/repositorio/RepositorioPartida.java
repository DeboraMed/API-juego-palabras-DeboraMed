package com.example.juegoDePalabrasAPP.repositorio;

import com.example.juegoDePalabrasAPP.modelo.Equipo;
import com.example.juegoDePalabrasAPP.modelo.Jugador;
import com.example.juegoDePalabrasAPP.modelo.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositorioPartida extends JpaRepository<Partida, Long> {
    List<Partida> findAll();
    Optional<Partida> findAllBy(Long id);
    Partida save(Partida partida);
    void deleteById(Long id);
    boolean existsById(Long id);
}

