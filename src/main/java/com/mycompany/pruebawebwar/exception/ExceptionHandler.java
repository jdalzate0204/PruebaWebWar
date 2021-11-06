package com.mycompany.pruebawebwar.exception;

import co.edu.unicundi.pruebaejbjar.exception.BussinessException;
import co.edu.unicundi.pruebaejbjar.exception.ResourceNotFoundException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author acer
 */
@Provider
public class ExceptionHandler implements ExceptionMapper<Exception>{
    @Context UriInfo uriInfo;
    
    @Override
    public Response toResponse(Exception ex) {
        ex.printStackTrace();
        ExceptionWraper ew;
        
        if (ex instanceof BussinessException | ex instanceof ArrayIndexOutOfBoundsException) {
            ew = new ExceptionWraper(Response.Status.BAD_REQUEST.getStatusCode(), Response.Status.BAD_REQUEST.getReasonPhrase(), ex.getMessage(), uriInfo.getPath());
            return Response.status(Response.Status.BAD_REQUEST).entity(ew).build();
        } else if (ex instanceof ResourceNotFoundException) {
            ew = new ExceptionWraper(Response.Status.NOT_FOUND.getStatusCode(), Response.Status.NOT_FOUND.getReasonPhrase(), ex.getMessage(), uriInfo.getPath());
            return Response.status(Response.Status.NOT_FOUND).entity(ew).build();
        }else if (ex instanceof CloneNotSupportedException) { //409
            ew = new ExceptionWraper(Response.Status.CONFLICT.getStatusCode(), 
                                      Response.Status.CONFLICT.getReasonPhrase(), 
                                      ex.getMessage(), 
                                      uriInfo.getPath());
            return Response.status(Response.Status.CONFLICT).entity(ew).build();
        }else if (ex instanceof CloneNotSupportedException) { //409
            ew = new ExceptionWraper(Response.Status.CONFLICT.getStatusCode(), 
                                      Response.Status.CONFLICT.getReasonPhrase(), 
                                      ex.getMessage(), 
                                      uriInfo.getPath());
            return Response.status(Response.Status.CONFLICT).entity(ew).build();
        }else if (ex instanceof CloneNotSupportedException) { //409
            ew = new ExceptionWraper(Response.Status.CONFLICT.getStatusCode(), 
                                      Response.Status.CONFLICT.getReasonPhrase(), 
                                      ex.getMessage(), 
                                      uriInfo.getPath());
            return Response.status(Response.Status.CONFLICT).entity(ew).build();
        }else {
            ew = new ExceptionWraper(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase(), "", uriInfo.getPath());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ew).build();
        }
    }
}
