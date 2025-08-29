package org.kaven.biblioteca.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.kaven.biblioteca.dominio.service.ILibroService;
import org.kaven.biblioteca.persistence.entity.Libro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ViewScoped
public class LibrosController {
    @Autowired
    ILibroService libroService;
    private List<Libro> libros;
    private Libro libroSeleccionado;
    private static final Logger logger = LoggerFactory.getLogger(LibrosController.class);

    @PostConstruct
    public void init(){
        cargarDatos();
    }

    public void cargarDatos(){
        this.libros = this.libroService.listarLibros();
        this.libros.forEach(libro -> logger.info(libro.toString()));
    }

    public void agregarCliente(){
        this.libroSeleccionado = new Libro();
    }
}
