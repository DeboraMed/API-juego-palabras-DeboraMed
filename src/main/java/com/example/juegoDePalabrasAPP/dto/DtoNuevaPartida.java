package com.example.juegoDePalabrasAPP.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoNuevaPartida {

    private Long num_intento;

    private String palabra_intento;

    private Long puntuacion;

    private Long id_juego;

    private Long id_jugador;
}
