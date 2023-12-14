package com.example.juegoDePalabrasAPP.servicio;

import com.example.juegoDePalabrasAPP.modelo.Equipo;
import com.example.juegoDePalabrasAPP.repositorio.RepositorioEquipo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
abstract class ServicioEquipo implements RepositorioEquipo {

    private final RepositorioEquipo repositorioEquipo;

    @Override
    public List<Equipo> findAll() {
        return repositorioEquipo.findAll();
    }

    @Override
    public Optional<Equipo> findById(Long id) {
        return repositorioEquipo.findById(id);
    }

    @Override
    public Equipo save(Equipo equipo) {
        equipo.setCreationDate(LocalDateTime.now());
        equipo.setModificationDate(LocalDateTime.now());
        return repositorioEquipo.save(equipo);
    }

    @Override
    public void deleteById(Long id) {
        repositorioEquipo.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repositorioEquipo.existsById(id);
    }
}
