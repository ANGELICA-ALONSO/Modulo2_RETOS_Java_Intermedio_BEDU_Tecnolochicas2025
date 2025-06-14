package org.bedu.inventario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//Esta interfaz extiende JpaRepository para gestionar operaciones CRUD sobre la entidad Producto
public interface ProductoRepository extends JpaRepository<Producto, Long>{

    //Método personalizado que busca producctos cuyo nombre contenga un texto específico (no sencible a mayúsculas)
    List<Producto> findByNombreContaining(String nombre);
    


    
}
