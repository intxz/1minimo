package edu.upc.dsa;

import edu.upc.dsa.models.Partida;
import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.models.Juego;

import java.util.Date;
import java.util.List;

public interface PartidasManager {
    public Juego addJuego(Juego juego);//
    public Partida addPartida(Partida partida);//
    public Juego CrearJuego(String idJ, String desc, int lvl);//
    public Partida IniciarJuego(String idJ,String idU);//
    public int getNivel(String idU);//
    public int getPuntuacion(String idU);//
    public Partida PasarNivel(String idU, int puntosConseguidos);
    public void FInalizarPartida(Usuario usuario);
    public List<Usuario> getPuntosDescendentes(Juego juego);//
    public List<Partida> getPartidasUsuario(String idU);//
}
