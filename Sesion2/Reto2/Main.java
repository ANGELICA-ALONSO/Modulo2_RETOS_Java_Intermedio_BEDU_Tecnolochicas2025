package Sesion2.Reto2;

public class Main {
    public static void main(String[] args) {
        RecursoMedico recursoMedico = new RecursoMedico();

        Runnable profesional1 = () -> {
            String nombreHilo = Thread.currentThread().getName();
            recursoMedico.usar(nombreHilo, "Sala de Operaciones");
        };

        Runnable profesional2 = () -> {
            String nombreHilo = Thread.currentThread().getName();
            recursoMedico.usar(nombreHilo, "Sala de Operaciones");
        };

        Thread hilo1 = new Thread(profesional1, "Dra. Sánchez");
        Thread hilo2 = new Thread(profesional2, "Dr. Gómez");

        hilo1.start();
        hilo2.start();
    }
}
