package com.mycompany.pruebawebwar.exception;

import co.edu.unicundi.pruebaejbjar.exception.BussinessException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author acer
 */
@Provider
public class ExceptionHandler implements ExceptionMapper<Exception>{

    @Override
    public Response toResponse(Exception ex) {
        ex.printStackTrace();
        ExceptionWraper ew;
        
        if (ex instanceof BussinessException) {
            ew = new ExceptionWraper("400", "BAD_REQUEST", ex.getMessage(), "/estudiantes/obtener2/{indice}");
            return Response.status(Response.Status.BAD_REQUEST).entity(ew).build();
        } else if (ex instanceof ArrayIndexOutOfBoundsException) {
            ew = new ExceptionWraper("400", "BAD_REQUEST", ex.getMessage(), "/estudiantes/obtener2/{indice}");
            return Response.status(Response.Status.BAD_REQUEST).entity(ew).build();
        } else {
            ew = new ExceptionWraper("500", "INTERNAL_SERVER_ERROR", "", "/estudiantes/obtener2/{indice}");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ew).build();
        }
    }
}
