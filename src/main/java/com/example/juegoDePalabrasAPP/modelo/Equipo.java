package com.example.juegoDePalabrasAPP.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_equipo", nullable = false)
    private Long id_equipo;
    private String nombre_equipo;
    private String escudo;
    private Long puntuacion;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    // Getter y Setter

    public Long getId_equipo() {
        return id_equipo;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public String getEscudo() {
        return escudo;
    }

    public Long getPuntuacion() {
        return puntuacion;
    }

    public void setId_equipo(Long id_equipo) {
        this.id_equipo = id_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

    public void setPuntuacion(Long puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setCreationDate(LocalDateTime now) {
    }

    public void setModificationDate(LocalDateTime now) {
    }
}
