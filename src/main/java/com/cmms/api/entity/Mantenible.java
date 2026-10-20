package com.cmms.api.entity;

import java.time.LocalDate;

public interface Mantenible {
    
int diasEntreMantenimientos();

default LocalDate proximoMantenimiento(LocalDate ultimoMantenimiento){
    return ultimoMantenimiento.plusDays(diasEntreMantenimientos());
}
}
