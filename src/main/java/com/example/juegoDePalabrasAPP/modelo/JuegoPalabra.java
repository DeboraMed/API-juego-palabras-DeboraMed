package com.example.juegoDePalabrasAPP.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JuegoPalabra {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_juego_palabra", nullable = false)
    private Long id_juego_palabra;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name="id_palabra")
    private Palabras id_palabra;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name="id_juego")
    private Juego id_juego;

    /*
    TODO: NO PUEDE IMPORTAR DIFICILTAD
    @Enumerated(EnumType.STRING)
    @Column(name="id_dificultad")
    Dificultad id_dificultad;
    */
}
