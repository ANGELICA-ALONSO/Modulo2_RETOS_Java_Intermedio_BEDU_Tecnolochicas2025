package Sesion3.Reto1;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;




public class confirmacionPedido {
    public static void main(String[] args) {
        List<entregaDomicilio> entregas = List.of(
            new entregaDomicilio("Arturo Nava", "Local", "123456789"),
            new entregaDomicilio("Lorena García", "Domicilio", null),
            new entregaDomicilio("Carlos Ramírez", "Local", null),
            new entregaDomicilio("Ana Gómez", "Domicilio", "555123456")
        );

        System.out.println("Números de teléfonos disponibles:");

        entregas.stream()
        .map(entregaDomicilio::getTelefono)
        .filter(Optional::isPresent)
        .map(Optional::get)
        .forEach(System.out::println);

        System.out.println("\n Detalles de las entregas:");

        entregas.stream()
        .filter(entrega -> entrega.getTelefono().isPresent())
        .forEach(System.out::println);

    }
}
