package com.mycompany.pruebawebwar.controller;

import co.edu.unicundi.pruebaejbjar.dto.LibroDto;
import co.edu.unicundi.pruebaejbjar.entity.Libro;
import co.edu.unicundi.pruebaejbjar.exception.ResourceNotFoundException;
import co.edu.unicundi.pruebaejbjar.service.ILibroService;
import java.util.List;
import javax.ejb.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author acer
 */
@Stateless
@Path("/libros")
public class LibroController {
    
    @EJB
    private ILibroService service;
    
    @POST
    @Path("/guardar")
    @Consumes(MediaType.APPLICATION_JSON) //Enviar la información en JSON
    public Response insertar(LibroDto libro) throws CloneNotSupportedException{
        this.service.guardar(libro);
        return Response.status(Response.Status.CREATED).build();
    }
    
    @GET
    @Path("/obtener")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtener() {
        List<Libro> listaLibro = service.listar();
        return Response.status(Response.Status.OK).entity(listaLibro).build();
    }
    
    @GET
    @Path("/obtener/{id}")
    @Produces(MediaType.APPLICATION_JSON) //Que se va a retornar
    public Response obtenerPorId(@PathParam("id") Integer id) throws ResourceNotFoundException {
        Libro libro = service.listarPorId(id);
        return Response.status(Response.Status.OK).entity(libro).build();
    }
    
    @PUT
    @Path("/editar")
    @Consumes(MediaType.APPLICATION_JSON) //Enviar la información en JSON
    public Response editar(Libro libro) throws CloneNotSupportedException{
        this.service.editar(libro);
        return Response.status(Response.Status.OK).build();
    }
    
    @DELETE
    @Path("/eliminar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("id") Integer id) throws ResourceNotFoundException {
          service.eliminar(id);
          return Response.status(Response.Status.NO_CONTENT).build();
    }
}
