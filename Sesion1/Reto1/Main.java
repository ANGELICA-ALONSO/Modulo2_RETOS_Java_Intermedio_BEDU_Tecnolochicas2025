package Sesion1.Reto1;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<OrdenMasa> ordenMasas = List.of(
                new OrdenMasa("OM001", 100),
                new OrdenMasa("OM002", 200)
        );

        List<OrdenPersonalizada> ordenPersonalizadas = List.of(
                new OrdenPersonalizada("OP001", 50, "Cliente A"),
                new OrdenPersonalizada("OP002", 75, "Cliente B")
        );

        List<OrdenPrototipo> ordenPrototipos = List.of(
                new OrdenPrototipo("OP001", 50, "Fase 1"),
                new OrdenPrototipo("OP002", 75, "Fase 2")
        );

        // Mostrar resumen de órdenes
        mostrarOrdenes(ordenMasas);
        mostrarOrdenes(ordenPersonalizadas);
        mostrarOrdenes(ordenPrototipos);

        // Procesar órdenes personalizadas
        GestionOrdenes.OrdenProduccion.procesarPersonalizadas(ordenPersonalizadas, 10);

        // Mostrar resumen de órdenes personalizadas después de procesar
        System.out.println("Resumen de órdenes personalizadas después de procesar:");
        mostrarOrdenes(ordenPersonalizadas);

        System.out.println("\n Termina el programa de gestión de órdenes.");
    }
    public static void mostrarOrdenes(List<? extends GestionOrdenes.OrdenProduccion> ordenes) {
        GestionOrdenes.OrdenProduccion.mostrarOrdenes(ordenes);
    }

}
