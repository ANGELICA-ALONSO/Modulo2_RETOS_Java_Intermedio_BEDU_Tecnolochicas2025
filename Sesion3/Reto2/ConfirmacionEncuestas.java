package Sesion3.Reto2;

import java.util.List;

public class ConfirmacionEncuestas {
    public static void main(String[] args) {
        
        //Lista de sucursales
        List<Sucursal> sucursales = List.of(
            new Sucursal("Centro", List.of(
                new Encuesta("José Pérez", "Excelente atención", 5),
                new Encuesta("María López", null, 4)
            )),

            new Sucursal("Norte", List.of(
                new Encuesta("Ana García", "Muy buena experiencia", 5),
                new Encuesta("Luis Martínez", "Podría mejorar el servicio", 3)
            )),

            new Sucursal("Sur", List.of(
                new Encuesta("Carlos Sánchez", "Muy satisfecho", 5),
                new Encuesta("Laura Torres", null, 4)

            )),

            new Sucursal("Este", List.of(
                new Encuesta("Pedro Ramírez", "Atención regular", 2),
                new Encuesta("Sofía Jiménez", "Deficiente", 1)
            ))

        );

        System.out.println("Confirmación de Encuestas por Sucursal:");

        sucursales.stream()
        .flatMap(sucursal -> sucursal.getEncuestas().stream()
        .filter(e -> e.getCalificacion() < 3)
        .map(encuesta -> new Confirmacion(encuesta, sucursal.getNombre()))
        )
        .filter(conf -> conf.getEncuesta().getComentario().isPresent())
        .map(conf -> {
            String comentario = conf.getEncuesta().getComentario().get();
            return "Encuesta de " + conf.getEncuesta().getPaciente() + " en la sucursal " + conf.getSucursal() + ": " + comentario + " (Calificación: " + conf.getEncuesta().getCalificacion() + ")";
        })
        .forEach(System.out::println);

    }
}
