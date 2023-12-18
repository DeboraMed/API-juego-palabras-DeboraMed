package com.example.juegoDePalabrasAPP.servicio;

import lombok.RequiredArgsConstructor;
import com.example.juegoDePalabrasAPP.modelo.Equipo;
import com.example.juegoDePalabrasAPP.modelo.Jugador;
import org.springframework.stereotype.Service;
import com.example.juegoDePalabrasAPP.repositorio.RepositorioJugador;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public abstract class ServicioJugador implements RepositorioJugador {

    private final RepositorioJugador repositorioJugador;

    @Override
    public List<Jugador> findAll() {
        return repositorioJugador.findAll();
    }

    @Override
    public Optional<Jugador> findById(Long id) {
        return repositorioJugador.findById(id);
    }

    @Override
    public Jugador save(Jugador jugador) {
        return repositorioJugador.save(jugador);
    }

    @Override
    public void deleteById(Long id) {
        repositorioJugador.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repositorioJugador.existsById(id);
    }

    @Override
    public List<Jugador> findByEquipo(Equipo equipo) {
        return repositorioJugador.findByEquipoId(equipo.getId());
    }

    @Override
    public List<Jugador> obtenerJugadoresPorEquipo(Long id_equipo) {
        return repositorioJugador.findByEquipoId(id_equipo);
    }


}


