package Sesion1.Reto2;

import java.util.List;

abstract class MaterialCurso {
    private final String titulo;
    protected String autor;

    public MaterialCurso(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String titulo(){
        return titulo;
    }

    public String autor(){
        return autor;
    }

    public void mostrarDetalle(){
        System.out.println("Título: " + titulo + ", Autor: " + autor);
    }


static class Video extends MaterialCurso {
    private int duracion;

    public Video(String titulo, String autor, int duracion) {
        super(titulo, autor);
        this.duracion = duracion;
    }

}

static class Articulo extends MaterialCurso {
    private int palabras;

    public Articulo(String titulo, String autor, int palabras) {
        super(titulo, autor);
        this.palabras = palabras;
    }

}

static class Ejercicio extends MaterialCurso{
    private boolean revisado;

    public Ejercicio(String titulo, String autor, boolean revisado) {
        super(titulo, autor);
        this.revisado = revisado;
    }
}

//Metodo  generico para mostrar los detalles de los materiales
//Este metodo recibe una lista de materiales y muestra los detalles de cada uno
public static void mostrarMateriales(List<? extends MaterialCurso> listaMateriales){
    System.out.println("Lista de materiales:");
    listaMateriales.forEach(MaterialCurso::mostrarDetalle);
}

//Metodo para contar la duracion de los videos
public static void contarDuracionVideos(List<? extends Video> listaVideos){
    int duracionTotal = 0;
    for (Video video : listaVideos){
        duracionTotal += video.duracion;
        System.out.println("Duración total de los videos: " + duracionTotal + " minutos");
    }
}

public static void contarPalabrasArticulos(List<? extends Articulo> listaArticulos){
    int totalPalabras = 0;
    for (Articulo articulo : listaArticulos){
        totalPalabras += articulo.palabras;
        System.out.println("Total de palabras en los artículos: " + totalPalabras);
    }
}

public static void contarEjerciciosRevisados(List<? extends Ejercicio> listaEjercicios){
    int totalEjerciciosRevisados = 0;
    for(Ejercicio ejercicio : listaEjercicios){
        if (ejercicio.revisado) {
            totalEjerciciosRevisados++;
        }
    }
    System.out.println("Total de ejercicios revisados: " + totalEjerciciosRevisados);
}


}






