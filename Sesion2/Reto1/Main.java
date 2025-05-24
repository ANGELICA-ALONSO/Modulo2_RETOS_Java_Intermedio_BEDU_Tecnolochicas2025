package Sesion2.Reto1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException{
        ExecutorService executor = Executors.newFixedThreadPool(4);

        System.out.println("Ejecutando sistemas de soporte vital, comunicaciones, control térmico y navegación...");
        Future<String> SistemaNavegacion = executor.submit(new SistemaNavegacion());
        Future<String> SistemaSoporteVital = executor.submit(new SistemaSoporteVital());
        Future<String> SistemaControlTermico = executor.submit(new SistemaControlTermico());
        Future<String> SistemaComunicaciones = executor.submit(new SistemaComunicaciones());


        System.out.println(SistemaNavegacion.get());
        System.out.println(SistemaSoporteVital.get());
        System.out.println(SistemaControlTermico.get());
        System.out.println(SistemaComunicaciones.get());

        executor.shutdown();

        System.out.println("Todos los sistemas están operativos.");

    }
    
}
