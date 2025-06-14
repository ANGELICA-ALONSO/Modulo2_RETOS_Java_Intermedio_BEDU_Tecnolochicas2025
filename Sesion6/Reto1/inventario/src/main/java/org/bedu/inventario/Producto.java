package org.bedu.inventario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {

    @Id // Campo que funcionara como clave primaria de la tabla PrimaryKey.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //El ID se generará automáticamente (autoincremental)    
    private Long id;
    private String nombre;
    private String descripcion;
    private double precio;

    protected Producto(){}

    public Producto(String nombre, String descripcion, double precio) {
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

    //Método que permite imprimir el botjeto de forma legible (útil para logs o consola)
    @Override
    public String toString() {
        return String.format("Producto[id=%d, nombre='%s', precio=%.2f]", id, nombre, precio);
    }
}
