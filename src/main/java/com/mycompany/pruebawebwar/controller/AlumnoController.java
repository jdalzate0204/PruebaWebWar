package com.mycompany.pruebawebwar.controller;

import co.edu.unicundi.pruebaejbjar.entity.Alumno;
import co.edu.unicundi.pruebaejbjar.exception.BussinessException;
import co.edu.unicundi.pruebaejbjar.exception.ResourceNotFoundException;
import co.edu.unicundi.pruebaejbjar.service.IAlumnoService;
import java.util.List;
import javax.ejb.*;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author acer
 */
@Stateless //Sin estado
@Path("/alumnos")
public class AlumnoController {
    
    @EJB
    private IAlumnoService service;
    
    @POST
    @Path("/guardar")
    @Consumes(MediaType.APPLICATION_JSON) //Enviar la información en JSON
    public Response insertar(@Valid Alumno alumno){
        this.service.guardar(alumno);
        return Response.status(Response.Status.CREATED).build();
    }
    
    @GET
    @Path("/obtener")
    @Produces(MediaType.APPLICATION_JSON) //Que se va a retornar
    public Response obtener() {
        List<Alumno> listaAlumno = service.listar();
        return Response.status(Response.Status.OK).entity(listaAlumno).build();
    }
    
    @GET
    @Path("/obtener/{id}")
    @Produces(MediaType.APPLICATION_JSON) //Que se va a retornar
    public Response obtenerPorId(@PathParam("id") Integer id) throws ResourceNotFoundException {
        Alumno alumno = service.listarPorId(id);
        return Response.status(Response.Status.OK).entity(alumno).build();
    }
    
    @PUT
    @Path("/editar")
    @Consumes(MediaType.APPLICATION_JSON) //Enviar la información en JSON
    //@Produces(MediaType.APPLICATION_JSON) //Se habilita en caso de retornar información
    public Response editar(Alumno alumno) throws BussinessException, ResourceNotFoundException{
        this.service.editar(alumno);
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
