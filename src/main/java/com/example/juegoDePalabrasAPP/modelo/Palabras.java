package com.example.juegoDePalabrasAPP.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Palabras")
public class Palabras {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_palabra", nullable = false)
    private Long id_palabra;
    private String dif_palabra;
    private String palabra;

    public Long getId_palabra() {
        return id_palabra;
    }

    public void setId_palabra(Long id_palabra) {
        this.id_palabra = id_palabra;
    }

    public String getDif_palabra() {
        return dif_palabra;
    }

    public void setDif_palabra(String dif_palabra) {
        this.dif_palabra = dif_palabra;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }
}
