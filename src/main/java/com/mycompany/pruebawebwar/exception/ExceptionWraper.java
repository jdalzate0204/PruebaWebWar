/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebawebwar.exception;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author acer
 */
public class ExceptionWraper implements Serializable {
    private Integer codigo;
    private String error;
    private String fecha;
    private String mensaje;
    private String url;

    public ExceptionWraper() {
    }
    
    public ExceptionWraper(Integer codigo, String error, String mensaje, String url) {
        this.codigo = codigo;
        this.error = error;
        this.fecha = new Date().toString();
        this.mensaje = mensaje;
        this.url = url;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
}
