package org.kaven.biblioteca;

import org.kaven.biblioteca.dominio.service.IGeneroService;
import org.kaven.biblioteca.dominio.service.ILibroService;
import org.kaven.biblioteca.dominio.service.IUbicacionService;
import org.kaven.biblioteca.persistence.entity.Genero;
import org.kaven.biblioteca.persistence.entity.Libro;
import org.kaven.biblioteca.persistence.entity.Ubicacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

//@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner {
	//@Autowired
	private ILibroService libroService;
    //@Autowired
    private IUbicacionService ubicacionService;
    //@Autowired
    private IGeneroService generoService;

	private static final Logger logger = LoggerFactory.getLogger(BibliotecaApplication.class);
	String sl = System.lineSeparator();

	public static void main(String[] args) {
		logger.info(" AQUÍ INICIA NUESTRA APLICACIÓN ");
		SpringApplication.run(BibliotecaApplication.class, args);
		logger.info(" AQUÍ TERMINA LA APLICACIÓN ");
	}

	@Override
	public void run(String... args) throws Exception {
		BibliotecaLibroApp();
	}

	private void BibliotecaLibroApp(){
		logger.info("+++++++++++++++APLICACIÓN DE RESGISTRO DE LIBROS+++++++++++++++");
		var salir = false;
		var consola = new Scanner(System.in);
		while (!salir ){
			var opcion = mostrarMenu(consola);
			salir = ejecutarOpciones(consola, opcion);
			logger.info(sl);
		}
	}

	private int mostrarMenu(Scanner consola){
		logger.info("""
				\n ***Aplicación***
				1. Listar todos los libros
				2. Buscar libro por código
				3. Agregar nuevo libro
				4. Modificar libro
				5. Eliminar libro
				6. Listar Generos de libros
				7. Listar Ubicaciones de libros	
				8. Salir
				Elije una ocion:" \s """);
		var opcion = Integer.parseInt(consola.nextLine());
		return opcion;
	}

	private boolean ejecutarOpciones(Scanner consola, int opcion){
		var salir = false;
		switch (opcion){
			case 1 ->{
				logger.info(sl+"***Listado de todos los clientes***"+sl);
				List<Libro> libros = libroService.listarLibros();
				libros.forEach(libro-> logger.info(libro.toString()+sl));
			}
			case 2 ->{
				logger.info(sl+"*** buscar Cliente por su código***"+sl);
				var codgo = Integer.parseInt(consola.nextLine());
				Libro libro = libroService.buscarLibroPorId(codgo);
				if (libro != null){
					logger.info("Cliente encontrado: "+sl + libro + sl);
				}else {
					logger.info("Cliente NO encontrado: "+ sl + libro + sl );
				}
			}
			case 3 ->{
				logger.info(sl+"Agregar nuevo libro"+ sl);
				logger.info("Ingrese el id del genero: ");
				var idGenero = Integer.parseInt(consola.nextLine());
				logger.info("Ingrese el id de la ubicacion: ");
				var idUbicacion = Integer.parseInt(consola.nextLine());
				logger.info("Ingrese el titulo: ");
				var titulo = consola.nextLine();
				logger.info("Ingrese el autor: ");
				var autor = consola.nextLine();
				logger.info("Ingrese la cantidad: ");
				var cantidad = Integer.parseInt(consola.nextLine());
				var libro = new Libro();
				libro.setIdgenero(idGenero);
				libro.setIdubicacion(idUbicacion);
				libro.setTitulo(titulo);
				libro.setAutor(autor);
				libro.setCantidad(cantidad);
				libroService.guardarLibro(libro);
				logger.info("Libro agregado: "+sl + libro + sl);
			}
			case 4 ->{
				logger.info(sl+"***Modificar Libros***"+sl);
				logger.info("Ingrese el código del Libro a editar ");
				var codigo = Integer.parseInt(consola.nextLine());
				Libro libro = libroService.buscarLibroPorId((codigo));
				if (libro != null){
					logger.info("Ingrese el id del nuevo genero: ");
					var idGenero = Integer.parseInt(consola.nextLine());
					logger.info("Ingrese el id de la nueva ubicacion: ");
					var idUbicacion = Integer.parseInt(consola.nextLine());
					logger.info("Ingrese el nuevo titulo: ");
					var titulo = consola.nextLine();
					logger.info("Ingrese el nuevo autor: ");
					var autor = consola.nextLine();
					logger.info("Ingrese la nuevo cantidad: ");
					var cantidad = Integer.parseInt(consola.nextLine());
					libro.setIdgenero(idGenero);
					libro.setIdubicacion(idUbicacion);
					libro.setTitulo(titulo);
					libro.setAutor(autor);
					libro.setCantidad(cantidad);
					libroService.guardarLibro(libro);
					logger.info("Libro modificado: "+sl + libro + sl);

				}else {
					logger.info("Libro NO encontrado: " + sl + libro + sl);
				}
			}
			case 5 ->{
				logger.info("***Eliminar libro***"+sl);
				logger.info("Ingrese el códugo de libro a eliminar ");
				var coddigo = Integer.parseInt(consola.nextLine());
				var libro = libroService.buscarLibroPorId(coddigo);
				if (libro != null){
					libroService.eliminarLibro(libro);
					logger.info("Libro eliminado, adios: " +sl + libro +sl);
				}else {
					logger.info("Libro NO encontrado" +sl + libro +sl);
				}
			}
			case 6 ->{
				logger.info(sl +"***Listado de Generos de libros***"+ sl);
				List<Genero> generos = generoService.listarGeneros();
				generos.forEach(genero1-> logger.info(genero1.toString()+sl));
			}
			case 7 ->{
				logger.info(sl + "***Listado de Ubicaciones de Libros***" + sl);
				List<Ubicacion> ubicaciones = ubicacionService.listarUbicaciones();
				ubicaciones.forEach(ubicacion1-> logger.info(ubicacion1.toString()+sl));
			}
			case 8 ->{
				logger.info("Hasta pronto vaquero!◘"+sl+sl);
				salir = true;
			}
			default -> logger.info("Opción no válida!!!");
		}
		return salir;
	}

}