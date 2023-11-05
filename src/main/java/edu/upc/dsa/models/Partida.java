package edu.upc.dsa.models;

import java.util.Date;

public class Partida {
    String idUser;
    String idGame;
    Date fecha;
    int puntosConseguidos;
    int nivelPartida;


    public Partida(String idUser, String idGame, Date fecha, int puntosConseguidos, int nivel) {
        this.idUser = idUser;
        this.idGame = idGame;
        this.fecha = fecha;
        this.puntosConseguidos = puntosConseguidos;
        this.nivelPartida = nivel;

    }

    public Partida(){}

    public String getIdUser() {
        return idUser;
    }


    public int getNivel() {
        return nivelPartida;
    }

    public int getPuntosConseguidos() {
        return puntosConseguidos;
    }

    public String getIdGame() {
        return idGame;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public void setIdGame(String idGame) {
        this.idGame = idGame;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setPuntosConseguidos(int puntosConseguidos) {
        this.puntosConseguidos = puntosConseguidos;
    }

    public int getNivelPartida() {
        return nivelPartida;
    }

    public void setNivelPartida(int nivelPartida) {
        this.nivelPartida = nivelPartida;
    }
}
