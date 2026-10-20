package com.cmms.api.entity;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Equipo implements Mantenible {
    private final String codigo;
    private String nombre;
    private final LocalDate fechaInstalacion;
    private String ubicacion;

    protected Equipo (String codigo, String nombre, LocalDate fechaInstalacion, String ubicacion) {
        validarCodigo(codigo);
        validarNombre(nombre);
        validarFechaInstalacion(fechaInstalacion);
        validarUbicacion(ubicacion);
 
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechaInstalacion = fechaInstalacion;
        this.ubicacion = ubicacion;
    }

    //validaciones privados no sobreescribibles......

    private void validarNombre(String nombre){
        if(nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacio");
        }
    }

    private void validarUbicacion(String ubicacion){
        if(ubicacion == null || ubicacion.isBlank()){
            throw new IllegalArgumentException("La ubicacion no puede ser nula o vacia");
        }
    }

    private void validarCodigo(String codigo){
        if(codigo == null || codigo.isBlank()){
            throw new IllegalArgumentException("El codigo no puede ser nulo o vacio");
        }
    }

    private void validarFechaInstalacion(LocalDate fechaInstalacion){
        if(fechaInstalacion == null){
            throw new IllegalArgumentException("La fecha de instalacion no puede ser nula");
        }
    }

    //getters

    public String getCodigo(){return codigo;}

    public String getNombre(){return nombre;}

    public LocalDate getFechaInstalacion(){return fechaInstalacion;}

    public String getUbicacion(){return ubicacion;}

    //setters

    public void setNombre(String nombre){
        validarNombre(nombre);
        this.nombre = nombre;
    }

    public void setUbicacion(String ubicacion){
        validarUbicacion(ubicacion);
        this.ubicacion = ubicacion;
    }    

    @Override
    public String toString(){
        return getClass().getSimpleName()+ " [codigo=" + codigo + 
                ", nombre=" + nombre + 
                ", fechaInstalacion=" + fechaInstalacion + 
                ", ubicacion=" + ubicacion + 
                "]";
    }

    @Override

    public boolean equals(Object obj){
        if(this == obj) return true;
        if(!(obj instanceof Equipo otro)) return false;
        return Objects.equals(codigo, otro.codigo);
    }

    @Override

    public int hashCode(){  
        return Objects.hash(codigo);
    }
}
