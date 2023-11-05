package edu.upc.dsa;

import edu.upc.dsa.models.Juego;
import edu.upc.dsa.models.Partida;
import edu.upc.dsa.models.Usuario;
import junit.framework.TestCase;
import java.util.Date;

public class PartidasManagerImplTest extends TestCase {

    PartidasManagerImpl pmi;
    Partida partida = new Partida();

    public void testAddJuego() {
        Juego juego = new Juego("id123","desc",6);
        Juego add = pmi.addJuego(juego);
        assertNotNull(add);
        assertEquals(juego, add);
    }

    public void testAddPartida() {

        Partida partida = new Partida("id123","id123",new Date(),67,2);
        Partida add = pmi.addPartida(partida);
        assertNotNull(add);
        assertEquals(partida, add);
    }


    public void testGetNivel() {
        Partida partida1 = new Partida("id123", "id123", new Date(), 100, 1);
        Partida partida2 = new Partida("id456", "id456", new Date(), 200, 2);
        pmi.partidas.add(partida1);
        pmi.partidas.add(partida2);
        int nivelU1 = pmi.getNivel("id123");
        assertEquals(1, nivelU1);
        int UsuarioNoExiste = pmi.getNivel("Usuario No Existente");
        assertEquals(-1, UsuarioNoExiste);
    }

    public void testGetPuntuacion() {
        Partida partida1 = new Partida("id123", "id123", new Date(), 100, 1);
        Partida partida2 = new Partida("id456", "id456", new Date(), 200, 2);
        pmi.partidas.add(partida1);
        pmi.partidas.add(partida2);
        int puntuacionU1 = pmi.getPuntuacion("id123");
        assertEquals(1, puntuacionU1);
        int UsuarioNoExiste = pmi.getNivel("Usuario No Existente");
        assertEquals(-1, UsuarioNoExiste);
    }


    public void testPasarNivel() {
    }

    public void testIniciarJuego() {
    }

    public void testFInalizarPartida() {
        Usuario user = new Usuario("id123","angel",100,null,pmi.partidas,3,true);
    }

    public void testGetPuntosDescendentes() {
    }

    public void testGetPartidasUsuario() {
    }
}