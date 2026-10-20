package com.cmms.api.dominio;

import com.cmms.api.entity.*;

import java.util.HashSet;
import java.util.Set;
import java.time.LocalDate;

public class PruebaDominio {
    public static void main(String[] args) {
        
        Equipo motor = new EquipoElectrico("1234567890", "Motor", LocalDate.now(), "Sala de maquinas", 220, 10);
        Equipo bomba = new EquipoMecanico("12345678", "Bomba", LocalDate.now(), "Sala de maquinas", 100, "Aceite");
        System.out.println(motor);
        System.out.println(bomba);

        Equipo duplicado = new EquipoElectrico("1234567890", "Motor", LocalDate.now(), "Sala de maquinas", 220, 10);
        Set<Equipo> equipos = new HashSet<>();
        equipos.add(motor);
        equipos.add(bomba);
        equipos.add(duplicado);
        System.out.println(equipos);
        System.out.println("Tamaño del set: " + equipos.size());
        System.out.println("Motor duplicado: " + equipos.contains(duplicado));

        probarInvalido("codigo vacio", () -> new EquipoElectrico("", "Motor", LocalDate.now(), "Sala de maquinas", 220, 10));
        probarInvalido("codigo null", () -> new EquipoElectrico(null, "Motor", LocalDate.now(), "Sala de maquinas", 220, 10));
        
        System.out.println("Dias entre mantenimientos: "+ motor.diasEntreMantenimientos());
        System.out.println("Dias entre mantenimientos: " +bomba.diasEntreMantenimientos());

        EquipoMecanico mecanico = (EquipoMecanico) bomba;
        probarInvalido("lubricante vacio por setters", () -> mecanico.setTipoLubricante(""));
    }
    private static void probarInvalido(String mensaje, Runnable accion) {
        try{
            accion.run();
            System.out.println("FALLO "+mensaje+" no lanzo ninguna excepcion");
        } catch (IllegalArgumentException e) {
            System.out.println("OK "+mensaje+" lanzo una excepcion: "+e.getMessage());
        }
    }

    
    
}
