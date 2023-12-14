package com.example.juegoDePalabrasAPP.repositorio;

import com.example.juegoDePalabrasAPP.modelo.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositorioEquipo extends JpaRepository<Equipo, Long> {

    List<Equipo> findAll();
    Optional<Equipo> findById(Long id);
    Equipo save(Equipo equipo);
    void deleteById(Long id);
    boolean existsById(Long id);
}
