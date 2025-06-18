package org.bedu.inventario.services;

import java.util.List;

import org.bedu.inventario.models.Producto;
import org.bedu.inventario.repositories.ProductoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    
    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> obtenerTodos() {
        return repository.findAll();    
    }

    public Producto guardar(Producto producto) {
        return repository.save(producto);
    }
}
