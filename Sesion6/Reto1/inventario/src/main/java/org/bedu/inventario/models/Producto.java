package org.bedu.inventario.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Producto {

    @Id // Campo que funcionara como clave primaria de la tabla PrimaryKey.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //El ID se generará automáticamente (autoincremental)    
    private Long id;
    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    @Min(1)
    private double precio;
    @ManyToOne
    @JoinColumn(name = "categoria_id") // nombre de la columna FK (clave foranea) en la tabla productos
    private Categoria categoria;

    protected Producto(){}

    public Producto(String nombre, String descripcion, double precio ) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    //Getter para acceder a los atributos necesarios para el funcionamiento de JPA y buenas prácticas.
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    //Método que permite imprimir el botjeto de forma legible (útil para logs o consola)
    @Override
    public String toString() {
        return String.format("Producto[id=%d, nombre='%s', precio=%.2f, categoria='%s']", id, nombre, precio, categoria != null ? categoria.getNombre() : "Sin categoria");
    }
}
