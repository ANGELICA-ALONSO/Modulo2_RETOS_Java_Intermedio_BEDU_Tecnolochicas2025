package Sesion1.Reto2;

import java.util.List;

import Sesion1.Reto2.MaterialCurso.Articulo;
import Sesion1.Reto2.MaterialCurso.Ejercicio;
import Sesion1.Reto2.MaterialCurso.Video;
import Sesion1.Reto2.MaterialCurso;
import Sesion1.Reto2.MaterialCurso.mostrarDetalle;


public class Main {
    
    public static void main(String[] args) {

        List<Video> listaVideos = List.of(
            new Video("Introducción a Java", "Juan Pérez", 120),
            new Video("Programación Orientada a Objetos", "Ana Gómez", 90)
        );

        List<Articulo> listaArticulos = List.of(
            new Articulo("Patrones de Diseño", "Luis Martínez", 1500),
            new Articulo("Estructuras de Datos", "María López", 2000)
        );
    
        List<Ejercicio> listaEjercicios = List.of(
            new Ejercicio("Ejercicio 1", "Carlos Sánchez", true),
            new Ejercicio("Ejercicio 2", "Laura Torres", false)
        );

    //Mostrar los detalles de los materiales
    //Este metodo recibe una lista de materiales y muestra los detalles de cada uno

    mostrarDetalle(listaVideos);
    mostrarDetalle(listaArticulos);
    mostrarDetalle(listaEjercicios);


    contarDuracionVideos(listaVideos);
    contarPalabrasArticulos(listaArticulos);
    contarEjerciciosRevisados(listaEjercicios);


    System.out.println("Fin del programa");


 }

    
}
