package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

import java.util.List;

public class Juego {

    String idJuego;
    String descripcion;
    int numNivel;

    public Juego(String idJuego, String descripcion, int numNivel) {
        this.idJuego = idJuego;
        this.descripcion = descripcion;
        this.numNivel = numNivel;
    }
    public Juego(){}

    public String getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(String idJuego) {
        this.idJuego = idJuego;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumNivel() {
        return numNivel;
    }

    public void setNumNivel(int numNivel) {
        this.numNivel = numNivel;
    }
}
