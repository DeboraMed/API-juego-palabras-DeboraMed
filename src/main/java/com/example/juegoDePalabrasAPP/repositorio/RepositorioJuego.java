package com.example.juegoDePalabrasAPP.repositorio;

import com.example.juegoDePalabrasAPP.modelo.Juego;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositorioJuego extends JpaRepository<Juego, Long> {

    List<Juego> findAll();
    Optional<Juego> findById(Long id);
    Juego save(Juego juego);
    void deleteById(Long id);
    boolean existsById(Long id);

}
