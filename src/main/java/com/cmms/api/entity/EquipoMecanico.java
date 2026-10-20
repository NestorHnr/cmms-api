package com.cmms.api.entity;

import java.time.LocalDate;

public class EquipoMecanico extends Equipo {

    private final double presionMaxima;
    private String tipoLubricante;

    public EquipoMecanico(String codigo, String nombre, LocalDate fechaInstalacion, String ubicacion, double presionMaxima, String tipoLubricante){
        super(codigo, nombre, fechaInstalacion, ubicacion);
        validarPresionmaxima(presionMaxima);
        validarTipoLubricante(tipoLubricante);
        this.presionMaxima = presionMaxima;
        this.tipoLubricante = tipoLubricante;
    }

    @Override
    public int diasEntreMantenimientos() {return 30;}

    //validaciones provadas no sobreescribibles.....

    private void validarPresionmaxima(double presionMaxima){
        if(presionMaxima <= 0){
            throw new IllegalArgumentException("La presion maxima no puede ser menor o igual a 0");
        }
    }

    private void validarTipoLubricante(String tipoLubricante){
        if(tipoLubricante == null || tipoLubricante.isBlank()){
            throw new IllegalArgumentException("El tipo de lubricante no puede ir null ni vacio");
        }
    }

    //Getters

    public double getPresionMaxima(){return presionMaxima;}
    public String getTipoLubricante(){return tipoLubricante;}

    //Setters

    public void setTipoLubricante(String tipoLubricante){
        validarTipoLubricante(tipoLubricante);
        this.tipoLubricante = tipoLubricante;
    }

    @Override
    public String toString() {
        return super.toString()+" [presionMaxima=" + presionMaxima + ", tipoLubricante=" + tipoLubricante + "]";
    }    
}
