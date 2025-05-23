package Sesion1.Reto1;

import java.util.List;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        List<OrdenMasa> ordenMasas = Arrays.asList(
                new OrdenMasa("OM001", 100),
                new OrdenMasa("OM002", 200)
        );

        List<OrdenPersonalizada> ordenPersonalizadas = Arrays.asList(
                new OrdenPersonalizada("OP001", 50, "Cliente A"),
                new OrdenPersonalizada("OP002", 75, "Cliente B")
        );

        List<OrdenPrototipo> ordenPrototipos = Arrays.asList(
                new OrdenPrototipo("OP001", 50, "Fase 1"),
                new OrdenPrototipo("OP002", 75, "Fase 2")
        );

        // Mostrar resumen de órdenes
        mostrarOrdenes(ordenMasas);
        mostrarOrdenes(ordenPersonalizadas);
        mostrarOrdenes(ordenPrototipos);

        // Procesar órdenes personalizadas
        procesarPersonalizadas(ordenPersonalizadas, 20);

        // Mostrar resumen de órdenes personalizadas después de procesar
        System.out.println("Resumen de órdenes personalizadas después de procesar:");
        mostrarOrdenes(ordenPersonalizadas);

        System.out.println("\n Termina el programa de gestión de órdenes.");
    }

    // Método para mostrar órdenes de masa
    public static void mostrarOrdenes(List<? extends Object> ordenes) {
        for (Object orden : ordenes) {
            System.out.println(orden);
        }
    }

    // Método para procesar órdenes personalizadas
    public static void procesarPersonalizadas(List<OrdenPersonalizada> ordenes, int cantidadProcesar) {
        for (OrdenPersonalizada orden : ordenes) {
            // Aquí puedes agregar la lógica para procesar la orden, por ejemplo:
            int nuevaCantidad = orden.getCantidad() - cantidadProcesar;
            orden.setCantidad(nuevaCantidad > 0 ? nuevaCantidad : 0);
        }
    }
}
