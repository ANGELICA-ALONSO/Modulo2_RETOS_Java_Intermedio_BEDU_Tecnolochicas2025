package org.bedu.inventario;


import org.bedu.inventario.models.Marca;
import org.bedu.inventario.models.Producto;
import org.bedu.inventario.repositories.MarcaRepository;
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
	public CommandLineRunner initData(ProductoRepository productoRepo, MarcaRepository marcaRepo) {
		return (args) -> {
			Marca lenovo = new Marca("Lenovo");
			marcaRepo.save(lenovo);
			Marca lg = new Marca("LG");
			marcaRepo.save(lg);
			Marca logitech = new Marca("Logitech");
			marcaRepo.save(logitech);
			//Guardar algunos productos
			productoRepo.save(new Producto("Laptop Lenovo", "AMD Ryzen 7, 16GB RAM", 18500.00, lenovo));
			productoRepo.save(new Producto("Mouse Inalámbrico", "Marca Logitech, sensor óptico", 350.00, logitech));
			productoRepo.save(new Producto("Monitor LG", "27 pulgadas, Full HD", 4300.00, lg));
			productoRepo.save(new Producto("Teclado Mecánico", "Switches azules, retroiluminado", 1200.00, logitech));
			productoRepo.save(new Producto("Monitor LG UltraWide", "34 pulgadas, QHD", 9500.00, lg));
			productoRepo.save(new Producto("Laptop Lenovo ThinkPad", "Intel i5, 8GB RAM", 14500.00, lenovo));
			
			// Muestra todos los productos
			System.out.println("Productos registrados:");
			productoRepo.findAll().forEach(System.out::println);

			// Muestra los productos agrupados por marca.
			System.out.println("Productos por marca:");
			marcaRepo.findAll().forEach(marca -> {
				System.out.println("Marca " + marca.getNombre() + ":");
				productoRepo.findAll().stream()
					.filter(p -> p.getMarca().getId().equals(marca.getId()))
					.forEach(p -> System.out.println("   - " + p.getNombre()));
			});


		};
	}

}
