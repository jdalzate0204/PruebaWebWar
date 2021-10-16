package com.mycompany.pruebawebwar.controller;

import java.util.*;
import javax.ejb.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import co.edu.unicundi.pruebaejbjar.service.IAlumnoService;

/**
 * Controlador para recibir las peticiones de todo lo que tiene que ver con estudiantes
 * @author James Alzate
 * @version 1.0
 * @since 14/09/2021
 */
@Stateless //Sin estado
@Path("/pruebas") //URL (Sustantivo y plural en clases)
public class PruebaController {
    
    @EJB
    private IAlumnoService service;
    
    /*@GET //Select
    @Path("/obtener") //URL (Verbos. ej: obtenerGeneral)
    @Produces(MediaType.APPLICATION_JSON) //Que se va a retornar
    public Response obtener(){ //Verbo nombrar metodos
        EstudianteService es = new EstudianteService();
        try {
            es.metodo();
            return Response.status(Response.Status.OK).build();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            ExceptionWraper ew = new ExceptionWraper("500", "INTERNAL_SERVER_ERROR", "", "/estudiantes/obtener");
            
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ew).build();
        }
    }
    
    @GET //Select
    @Path("/obtener2/{indice}") //URL (Verbos. ej: obtenerGeneral)
    @Produces(MediaType.APPLICATION_JSON) //Que se va a retornar
    public Response obtener2(@PathParam("indice") int indice) 
            throws ArrayIndexOutOfBoundsException, BussinessException, Exception{ //Verbo nombrar metodos
        EstudianteService es = new EstudianteService();
        es.metodo2(indice);
        return Response.status(Response.Status.OK).build();
    }*/
    
    @GET //Select
    @Path("/obtenerListaPorSemestre/{semestre}/{genero}") //URL con parametro (no mandar más de 3 variables)
    @Produces(MediaType.APPLICATION_JSON) //Retornar información en JSON
    public Response obtenerLista(@PathParam("semestre") String semestre, 
                                    @PathParam("genero") String genero){ //Añadir parametros
        System.out.println(semestre + " " + genero);
        List<String> listaEstudiantes = new ArrayList<>();
        listaEstudiantes.add("James");
        listaEstudiantes.add("Ivan");
        listaEstudiantes.add("Julian");
        return Response.status(Response.Status.OK).entity(listaEstudiantes)
                .header("TipoDato", "Lista de objeto").build();
    }
    
    @POST //Insert
    @Path("/insertarPrueba")
    @Consumes(MediaType.APPLICATION_JSON) //Enviar la información en JSON
    //@Produces(MediaType.APPLICATION_JSON) //Se habilita en caso de retornar información
    public Response insertar(List<String> listaEstudiantes){
        for (String le : listaEstudiantes) {
            System.out.println(le);
        }
        System.out.println("Registrado correctamente");
        return Response.status(Response.Status.CREATED).build();
    }
    
    @PUT //Update
    @Path("/editar")
    @Consumes(MediaType.APPLICATION_JSON) //Enviar la información en JSON
    //@Produces(MediaType.APPLICATION_JSON) //Se habilita en caso de retornar información
    public void editar(List<String> listaEstudiantes){
        for (String le : listaEstudiantes) {
            System.out.println(le);
        }
        System.out.println("Editado correctamente");
        //return listaEstudiantes;
    }
    
    @DELETE //Delete
    @Path("/eliminarPorId/{id}") //URL con parametro (no mandar más de 3 variables)
    @Produces(MediaType.APPLICATION_JSON) //Retornar información en JSON
    public void eliminarPorId(@PathParam("id") int id){
        System.out.println(id);
        //El delete nunca retorna nada
    }
    
    //EJEMPLO
    /*@GET //Select
    @Path("/obtenerJson") //URL con parametro (no mandar más de 3 variables)
    @Produces(MediaType.APPLICATION_JSON) //Retornar información en JSON
    public EstudianteDto obtenerJson(){ //Añadir parametros
        List<String> listaMateria = new ArrayList<>();
        listaMateria.add("Programación 1");
        listaMateria.add("Ingenieria de Software 1");
        listaMateria.add("Linea de Profundización 1");
        
        int[] vector = {1,2,3,4,5,6,7};
        EstudianteDto ob = new EstudianteDto("1007303580", "James", "Alzate", 20, "james.alzate22@gmail.com", listaMateria, vector);
        return ob;
    }

    @POST //Insert
    @Path("/insertar")
    @Consumes(MediaType.APPLICATION_JSON) //Enviar la información en JSON
    //@Produces(MediaType.APPLICATION_JSON) //Se habilita en caso de retornar información
    public void insertar(EstudianteDto estudiante){
        System.out.println("Registrado correctamente" + estudiante.getNombre());
        //return listaEstudiantes;
    }*/
    
    @GET
    @Path("/obtenerEJB")
    @Produces(MediaType.APPLICATION_JSON) //Se habilita en caso de retornar información
    public Response obtenerEJB(){
        service.listar();
        return Response.status(Response.Status.OK).build();
    }
}
