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
    private Long num_intento;
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

}
