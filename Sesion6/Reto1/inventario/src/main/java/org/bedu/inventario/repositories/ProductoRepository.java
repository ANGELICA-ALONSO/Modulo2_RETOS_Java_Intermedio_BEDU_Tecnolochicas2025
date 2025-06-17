package org.bedu.inventario.repositories;



import java.util.List;

import org.bedu.inventario.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


//Esta interfaz extiende JpaRepository para gestionar operaciones CRUD sobre la entidad Producto
public interface ProductoRepository extends JpaRepository<Producto, Long>{

    //Método personalizado que busca producctos cuyo nombre contenga un texto específico (no sencible a mayúsculas)


    //Reto1
    List<Producto> findByPrecioGreaterThan(double precio);
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
    List<Producto> findByPrecioBetween(double min, double max);
    List<Producto> findByNombreStartingWithIgnoreCase(String prefijo);
}
