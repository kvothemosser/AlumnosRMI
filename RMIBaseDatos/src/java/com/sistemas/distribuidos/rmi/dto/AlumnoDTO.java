/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemas.distribuidos.rmi.dto;

import java.io.Serializable;

/**
 *
 * @author Moisés Tapia Téllez.
 */
public class AlumnoDTO implements Serializable {

    private Integer id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String matricula;
    private String calificacion;

    public AlumnoDTO() {
        
    }
    
    public AlumnoDTO(Integer id, String nombre, String apellidoPaterno, 
            String apellidoMaterno, String matricula, String calificacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.matricula = matricula;
        this.calificacion = calificacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "AlumnoDTO{" + "id=" + id + ", nombre=" + nombre + 
                ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + 
                apellidoMaterno + ", matricula=" + matricula + 
                ", calificacion=" + calificacion + '}';
    }

    
}
