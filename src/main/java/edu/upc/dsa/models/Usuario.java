package edu.upc.dsa.models;

import java.util.Date;
import java.util.List;

public class Usuario {

    String idUsuario;
    String nombre;
    int puntos;
    Partida partida;
    List<Partida> partidas;
    int nivelActual;
    boolean jugando=false;



    public Usuario(String idUsuario, String nombre, int puntos, int nivelActual,boolean jugando) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.puntos = puntos;
        this.partida=null;
        this.partidas = null;
        this.nivelActual= nivelActual;
        this.jugando = jugando;
    }

    public Usuario(){}

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = null;
    }

    public int getNivelActual() {
        return nivelActual;
    }

    public void setNivelActual(int nivelActual) {
        this.nivelActual = nivelActual;
    }
    public boolean isJugando() {
        return jugando;
    }

    public void setJugando(boolean jugando) {
        this.jugando = jugando;
    }
    public List<Partida> getPartidas() {
        return partidas;
    }
}
