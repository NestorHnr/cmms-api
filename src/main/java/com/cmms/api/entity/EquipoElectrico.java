package com.cmms.api.entity;

import java.time.LocalDate;

public class EquipoElectrico extends Equipo {

    private final int voltaje;
    private final double amperaje;

    public EquipoElectrico(String codigo, String nombre, LocalDate fechaInstalacion, String ubicacion, int voltaje, double amperaje) {
        super(codigo, nombre, fechaInstalacion, ubicacion);
        validarVoltaje(voltaje);
        validarAmperaje(amperaje);
        this.voltaje = voltaje;
        this.amperaje = amperaje;
    }

    @Override
    public int diasEntreMantenimientos() {return 90;}

    //validaciones privados no sobreescribibles......

    private void validarVoltaje(int voltaje){
        if(voltaje <= 0){
            throw new IllegalArgumentException("El voltaje no puede ser menor o igual a 0");
        }
    }
    private void validarAmperaje(double amperaje){
        if(amperaje <= 0){
            throw new IllegalArgumentException("El amperaje no puede ser menor o igual a 0");
        }
    }

    //getters
    public int getVoltaje(){return voltaje;}
    public double getAmperaje(){return amperaje;}

    @Override
    public String toString() {
        return super.toString()+" [voltaje=" + voltaje + ", amperaje=" + amperaje + "]";
    }
}
