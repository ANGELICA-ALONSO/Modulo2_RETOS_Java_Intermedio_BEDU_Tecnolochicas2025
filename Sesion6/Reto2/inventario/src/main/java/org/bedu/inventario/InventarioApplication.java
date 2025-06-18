package org.bedu.inventario;


import org.bedu.inventario.models.Producto;
import org.bedu.inventario.repositories.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ProductoRepository productoRepo) {
		return args -> {
			//Guardar algunos productos
			productoRepo.save(new Producto("Laptop Lenovo", "AMD Ryzen 7, 16GB RAM", 18500.00));
			productoRepo.save(new Producto("Mouse Inalámbrico", "Marca Logitech, sensor óptico", 350.00));
			productoRepo.save(new Producto("Monitor LG", "27 pulgadas, Full HD", 4300.00));

			//Mostrar todos los procuctos registrados
			System.out.println("Productos registrados:");
			productoRepo.findAll().forEach(System.out::println);

			//Mostrar Productos con precio mayor a 500
			System.out.println("Productos con precio mayor a 500");
			productoRepo.findByPrecioGreaterThan(500.0).forEach(System.out::println);

			// Mostrar Productos que contienen 'lap'
			System.out.println("Mostrar Productos que contienen 'lap'");
			productoRepo.findByNombreContainingIgnoreCase("lap").forEach(System.out::println);


			// Mostrar Productos con precio entre 400 y 1000
			System.out.println("Mostrar Productos con precio entre 400 y 1000");
			productoRepo.findByPrecioBetween(400, 1000);

			// Mostrar Productos cuyo nombre empieza con 'm'
			System.out.println("Mostrar Productos cuyo nombre empieza con 'm'");
			productoRepo.findByNombreStartingWithIgnoreCase("m");
		};
	}

}
