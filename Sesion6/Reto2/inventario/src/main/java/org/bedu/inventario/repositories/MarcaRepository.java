package org.bedu.inventario.repositories;

import java.util.List;

import org.bedu.inventario.models.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
    List<Marca> findByNombre(String nombre);
}
