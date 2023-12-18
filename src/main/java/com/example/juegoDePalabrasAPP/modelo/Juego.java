package com.example.juegoDePalabrasAPP.modelo;

import com.example.juegoDePalabrasAPP.Enum.Dificultad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_juego", nullable = false)
    private Long id_juego;

    @Enumerated(EnumType.STRING)
    @Column(name="Dificultad")
    private Dificultad dificultad_juego;

    public void setId_juego(Long id_juego) {
        this.id_juego = id_juego;
    }

    public void setDificultad_juego(String dificultad_juego) {
        this.dificultad_juego = Dificultad.valueOf(dificultad_juego);
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setIntentos_max(Long intentos_max) {
        this.intentos_max = intentos_max;
    }

    public Long getId_juego() {
        return id_juego;
    }

    public Dificultad getDificultad_juego() {
        return dificultad_juego;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Long getIntentos_max() {
        return intentos_max;
    }

    private String descripcion;
    private Long intentos_max;
}
