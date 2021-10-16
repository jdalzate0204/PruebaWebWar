package com.mycompany.pruebawebwar.controller;

import co.edu.unicundi.pruebaejbjar.entity.Alumno;
import co.edu.unicundi.pruebaejbjar.service.IAlumnoService;
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
}
