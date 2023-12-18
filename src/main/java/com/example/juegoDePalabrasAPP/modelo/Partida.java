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
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_partida", nullable = false)
    private Long id_partida;
    private Long num_intento = 5L;
    private String palabra_intento;
    @Column(name = "hora_comienzo")
    private LocalDateTime hora_comienzo;

    @Column(name = "hora_final")
    private LocalDateTime hora_final;
    private Long puntuacion;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name="id_jugador")
    private Jugador id_jugador;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name="id_juego")
    private Juego id_juego;

    // Getter y Setter

    public Long getId_partida() {
        return id_partida;
    }

    public void setId_partida(Long id_partida) {
        this.id_partida = id_partida;
    }

    public Long getNum_intento() {
        return num_intento;
    }

    public void setNum_intento(Long num_intento) {
        this.num_intento = num_intento;
    }

    public String getPalabra_intento() {
        return palabra_intento;
    }

    public void setPalabra_intento(String palabra_intento) {
        this.palabra_intento = palabra_intento;
    }

    public LocalDateTime getHora_comienzo() {
        return hora_comienzo;
    }

    public void setHora_comienzo(LocalDateTime hora_comienzo) {
        this.hora_comienzo = hora_comienzo;
    }

    public LocalDateTime getHora_final() {
        return hora_final;
    }

    public void setHora_final(LocalDateTime hora_final) {
        this.hora_final = hora_final;
    }

    public Long getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Long puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Jugador getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(Jugador id_jugador) {
        this.id_jugador = id_jugador;
    }

    public Juego getId_juego() {
        return id_juego;
    }

    public void setId_juego(Juego id_juego) {
        this.id_juego = id_juego;
    }

}
