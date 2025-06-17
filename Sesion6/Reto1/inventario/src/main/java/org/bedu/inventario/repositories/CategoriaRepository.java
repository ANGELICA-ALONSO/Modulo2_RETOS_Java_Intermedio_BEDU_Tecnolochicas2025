package org.bedu.inventario.repositories;

import java.util.List;

import org.bedu.inventario.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    List<Categoria> findByNombre(String nombre);
}
