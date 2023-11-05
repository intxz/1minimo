package edu.upc.dsa.services;
import edu.upc.dsa.PartidasManager;
import edu.upc.dsa.PartidasManagerImpl;
import edu.upc.dsa.models.Partida;
import edu.upc.dsa.models.Juego;
import edu.upc.dsa.models.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
@Api(value = "/Partida", description = "Endpoint to Partidas Service")
@Path("/Partida")
public class PartidasService {
    private PartidasManager tm;

    public PartidasService(){
        this.tm = PartidasManagerImpl.getInstance();
    }
    @GET
    @ApiOperation(value = "get a Level", notes = "Level")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Integer.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNivel(@PathParam("id") String idU) {
         Integer i = this.tm.getNivel(idU);
        if (i == null) return Response.status(404).build();
        else  return Response.status(201).entity(i).build();
    }

    @GET
    @ApiOperation(value = "get Points", notes = "Points")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Integer.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPuntuacion(@PathParam("id") String idU) {
        Integer i = this.tm.getPuntuacion(idU);
        if (i == null) return Response.status(404).build();
        else  return Response.status(201).entity(i).build();
    }
    @GET
    @ApiOperation(value = "get a Level", notes = "Level")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPuntosDescendentes(Juego juego) {
        List<Usuario> users = this.tm.getPuntosDescendentes(juego);
        if (users == null) return Response.status(404).build();
        else  return Response.status(201).entity(users).build();
    }
    @GET
    @ApiOperation(value = "get a Level", notes = "Level")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Partida.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPartidasUsuario(@PathParam("id") String idU) {
        List<Partida> partidas = this.tm.getPartidasUsuario(idU);
        if (partidas == null) return Response.status(404).build();
        else  return Response.status(201).entity(partidas).build();
    }

    @POST
    @ApiOperation(value = "create a new Game", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Juego.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newJuego(Juego juego) {

        if (juego.getNumNivel()==-1 || juego.getDescripcion()==null)  return Response.status(500).entity(juego).build();
        this.tm.addJuego(juego);
        return Response.status(201).entity(juego).build();
    }

    @POST
    @ApiOperation(value = "create a new match", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Juego.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newPartida(Partida partida) {

        if (partida.getIdGame()==null || partida.getIdUser()==null)  return Response.status(500).entity(partida).build();
        this.tm.addPartida(partida);
        return Response.status(201).entity(partida).build();
    }

    @PUT
    @ApiOperation(value = "update a Level", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "not found")
    })
    @Path("/")
    public Response updateLevel(String idU, int p) {

        Partida partida = this.tm.PasarNivel(idU,p);

        if (partida == null) return Response.status(404).build();

        return Response.status(201).build();
    }
    @PUT
    @ApiOperation(value = "update a Level", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "not found")
    })
    @Path("/")
    public Response endLevel(Usuario user) {

        this.tm.FInalizarPartida(user);
        if (user== null) return Response.status(404).build();
        return Response.status(201).build();
    }
}
