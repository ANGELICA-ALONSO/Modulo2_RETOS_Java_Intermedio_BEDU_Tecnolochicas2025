package Sesion1.Reto1;

import Sesion1.Reto1.GestionOrdenes.OrdenProduccion;

public class OrdenPrototipo extends OrdenProduccion{
    private String faseDesarrollo;

    public OrdenPrototipo(String codigo, int cantidad, String faseDesarrollo) {
        super(codigo, cantidad);
        this.faseDesarrollo = faseDesarrollo;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + ", fase de desarrollo: " + faseDesarrollo;
    }


}