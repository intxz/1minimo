package edu.upc.dsa;

import edu.upc.dsa.models.Juego;
import edu.upc.dsa.models.Partida;
import edu.upc.dsa.models.Usuario;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

public class PartidasManagerImpl implements PartidasManager{
    private static  PartidasManager instance;
    protected List<Usuario> users;
    protected List<Juego> juegos;
    protected List<Partida> partidas;
    final static Logger logger = Logger.getLogger(PartidasManagerImpl.class);

    private PartidasManagerImpl(){this.users=new LinkedList<>(); this.juegos=new LinkedList<>();
    this.partidas=new LinkedList<>();}
    public static PartidasManager getInstance(){
        if (instance==null) instance = new PartidasManagerImpl();
        return instance;
    }
    public Juego addJuego(Juego juego){
        logger.info("nuevo Juego"+juego);
        this.juegos.add(juego);
        logger.info("añadido");
        return juego;
    }
    public Partida addPartida(Partida partida){
        logger.info("nueva Partida"+partida);
        this.partidas.add(partida);
        logger.info("añadido");
        return partida;
    }
    public Juego CrearJuego(String idJ, String des, int Nnivel){
        return this.addJuego(new Juego(idJ,des,Nnivel));
    }

    public int getNivel(String idU){
        logger.info("getNivel("+idU+")");
        for (Partida p: this.partidas) {
            if (p.getIdUser().equals(idU)) {
                return p.getNivel();
            }
        }
        logger.warn("not found " + idU);
        return -1;
    }
    public int getPuntuacion(String idU){
        logger.info("getPuntuacion("+idU+")");
        for (Partida p: this.partidas) {
            if (p.getIdUser().equals(idU)) {
                logger.info("getPuntuacion("+idU+"): "+p);
                return p.getPuntosConseguidos();
            }
        }
        logger.warn("not found " + idU);
        return -1;
    }
    public int getNivelJuego(String idJ){
        logger.info("getNivelJuego("+idJ+")");
        for (Juego j: this.juegos) {
            if (j.getIdJuego().equals(idJ)) {
                logger.info("getNivelJuego("+idJ+"): "+j);
                return j.getNumNivel();
            }
        }
        logger.warn("not found " + idJ);
        return -1;
    }
    @Override
    public Partida PasarNivel(String idU, int puntos){
        logger.info("PasarNivel("+idU+","+puntos+")");
        Date fecha = new Date();
        for(Usuario u :users){
            if (u.getIdUsuario().equals(idU)){
                if(u.getNivelActual() < getNivelJuego(u.getPartida().getIdGame())) {
                    logger.info(u+" updated ");
                    return this.addPartida(new Partida(idU,u.getPartida().getIdGame(), fecha,
                            puntos + getPuntuacion(idU), getNivel(idU) + 1));
                } else if (u.getNivelActual()==getNivelJuego(u.getPartida().getIdGame())) {
                    u.setJugando(false);
                    logger.info(u+" updated ");
                    return addPartida(new Partida(idU, u.getPartida().getIdGame(), fecha,
                            (puntos + getPuntuacion(idU)+100), 3));
                    //le añado +100 puntos por haber alcanzdo el nivel maximo
                }else {
                    logger.warn("not founf"+u);
                }
            }
        }
        return null;
    }
    @Override
    public Partida IniciarJuego(String idJ,String idU){
        Juego juego = new Juego();
        Usuario usuario= new Usuario();
        if (juego.getIdJuego() == idJ && usuario.getIdUsuario() == idU){
            usuario.setJugando(true);
            logger.info("new Game added");
            return addPartida(new Partida(idJ,idU,new Date(),50,1));
        }else{
            logger.warn("not found"+juego + "and"+ usuario);
            return null;
        }
    }
   @Override
   public void FInalizarPartida(Usuario usuario){
        usuario.setJugando(false);
   }
   @Override
   public List<Usuario> getPuntosDescendentes(Juego juego){
       logger.info("getPuntosDescendentes("+juego+")");
        if(juego == null){
            logger.warn("not found"+juego);
        }
        for (Partida p: partidas){
            Usuario usuario = new Usuario();
            if (!users.contains(usuario)){
                users.add(usuario);
            }
        }
        users.sort((u1,u2) -> Integer.compare(u2.getPuntos(), u1.getPuntos()));
       logger.info("getPuntosDescendentes("+juego+"): "+users);
        return users;
   }
   @Override
   public List<Partida> getPartidasUsuario(String idU){
       logger.info("getPartidasusuario("+idU+")");
        Usuario usuario = new Usuario();
        if(usuario.getIdUsuario()!= idU){
            logger.warn("not founf"+usuario);
        }
       for(Usuario u : users){
           partidas = u.getPartidas();
       }
       logger.info("getPartidasUsuario("+idU+"): "+partidas);
       return partidas;
   }


}
