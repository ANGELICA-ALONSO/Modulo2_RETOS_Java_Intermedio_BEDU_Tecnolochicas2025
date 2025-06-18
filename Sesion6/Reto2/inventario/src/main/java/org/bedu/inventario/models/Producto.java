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

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    protected Producto(){}

    public Producto(String nombre, String descripcion, double precio, Marca marca) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.marca = marca;
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

    public Marca getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
                + ", categoria=" + categoria + ", marca=" + marca + "]";
    }
}
