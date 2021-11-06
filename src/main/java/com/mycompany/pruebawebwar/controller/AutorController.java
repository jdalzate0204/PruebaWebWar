package com.mycompany.pruebawebwar.controller;

import co.edu.unicundi.pruebaejbjar.dto.AutorDto;
import co.edu.unicundi.pruebaejbjar.entity.Autor;
import co.edu.unicundi.pruebaejbjar.exception.ResourceNotFoundException;
import co.edu.unicundi.pruebaejbjar.service.IAutorService;
import co.edu.unicundi.pruebaejbjar.view.VistaAutorLibro;
import java.util.List;
import javax.ws.rs.*;
import javax.ejb.*;
import javax.ws.rs.core.*;

/**
 *
 * @author acer
 */
@Stateless
@Path("/autores")
public class AutorController {
    
    //@EJB(beanName = "AutorServiceImpl") //Se pone cuando la interface es implementada por varias clases
    @EJB
    private IAutorService service;
    
    @POST
    @Path("/guardar")
    @Consumes(MediaType.APPLICATION_JSON) //Enviar la información en JSON
    public Response insertar(Autor autor) throws CloneNotSupportedException{
        this.service.guardar(autor);
        return Response.status(Response.Status.CREATED).build();
    }
    
    @GET
    @Path("/obtener")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtener() {
        List<Autor> listaAutor = service.listar();
        return Response.status(Response.Status.OK).entity(listaAutor).build();
    }
    
    @GET
    @Path("/obtener2")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerModelMapper() {
        List<AutorDto> listaAutor = service.listarModelMaper();
        return Response.status(Response.Status.OK).entity(listaAutor).build();
    }
    
    @GET
    @Path("/obtenerDatosAutor")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerDatos() {
        List<VistaAutorLibro> lista = service.obtener();
        return Response.status(Response.Status.OK).entity(lista).build();
    }
    
    @GET
    @Path("/obtener/{id}")
    @Produces(MediaType.APPLICATION_JSON) //Que se va a retornar
    public Response obtenerPorId(@PathParam("id") Integer id) throws ResourceNotFoundException {
        Autor autor = service.listarPorId(id);
        return Response.status(Response.Status.OK).entity(autor).build();
    }
    
    @DELETE
    @Path("/eliminar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("id") Integer id) throws ResourceNotFoundException {
          service.eliminar(id);
          return Response.status(Response.Status.NO_CONTENT).build();
    }  
    
    @PUT
    @Path("/editar")
    @Consumes(MediaType.APPLICATION_JSON) //Enviar la información en JSON
    public Response editar(Autor autor) {
        this.service.editar(autor);
        return Response.status(Response.Status.OK).build();
    }
}

