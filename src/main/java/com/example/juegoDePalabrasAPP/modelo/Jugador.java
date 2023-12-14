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
@Table(name = "jugador")
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_jugador", nullable = false)
    private Long id_jugador;
    private String usuario;
    private Long puntuacion;
    private String avatar;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name="id_equipo")
    private Equipo equipo;

    // Getter y Setter

    public Long getId_jugador() {
        return id_jugador;
    }

    public String getUsuario() {
        return usuario;
    }

    public Long getPuntuacion() {
        return puntuacion;
    }

    public String getAvatar() {
        return avatar;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setId_jugador(Long id_jugador) {
        this.id_jugador = id_jugador;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPuntuacion(Long puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public void setCreationDate(LocalDateTime now) {
    }

    public void setModificationDate(LocalDateTime now) {
    }
}
