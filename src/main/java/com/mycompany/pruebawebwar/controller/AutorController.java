/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebawebwar.controller;

import co.edu.unicundi.pruebaejbjar.entity.Alumno;
import co.edu.unicundi.pruebaejbjar.entity.Autor;
import co.edu.unicundi.pruebaejbjar.service.IAutorService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author acer
 */
@Stateless //Sin estado
@Path("/autores")
public class AutorController {
    
    //@EJB(beanName = "AutorServiceImpl") //Se pone cuando la interface es implementada por varias clases
    @EJB
    private IAutorService service;
    
    @POST
    @Path("/guardar")
    @Consumes(MediaType.APPLICATION_JSON) //Enviar la información en JSON
    public Response insertar(Autor autor){
        this.service.guardar(autor);
        return Response.status(Response.Status.CREATED).build();
    }
    
    @GET
    @Path("/obtener")
    @Produces(MediaType.APPLICATION_JSON) //Que se va a retornar
    public Response obtener() {
        List<Autor> listaAlumno = service.listar();
        return Response.status(Response.Status.OK).entity(listaAlumno).build();
    }
}
