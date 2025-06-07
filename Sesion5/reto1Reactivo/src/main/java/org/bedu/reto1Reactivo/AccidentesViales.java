package org.bedu.reto1Reactivo;

public class AccidentesViales {

    public  enum Prioridad {
        BAJA, MEDIA, ALTA
    }
    private final String ubicacion;
    private final Prioridad prioridad;

    public AccidentesViales(String ubicacion, Prioridad prioridad) {
        this.ubicacion = ubicacion;
        this.prioridad = prioridad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }
    
}
