package org.kaven.biblioteca.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.kaven.biblioteca.dominio.service.ILibroService;
import org.kaven.biblioteca.persistence.entity.Libro;
import org.primefaces.PrimeFaces;
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
    public void init() {
        cargarDatos();
    }

    public void cargarDatos() {
        this.libros = this.libroService.listarLibros();
        this.libros.forEach(libro -> logger.info(libro.toString()));
    }

    public void agregarLibros() {
        this.libroSeleccionado = new Libro();
    }

    public void guardarLibros(){
        logger.info("Libro a guardar" + this.libroSeleccionado);

        if (this.libroSeleccionado.getIdlibro() == null){
            this.libroService.guardarLibro(this.libroSeleccionado);
            this.libros.add(this.libroSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Libro agregado"));
        }
        else{
            this.libroService.guardarLibro(this.libroSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Libro Actualizado"));
        }
        PrimeFaces.current().executeScript("PF('VentanaModalLibro').hide()");
        PrimeFaces.current().ajax().update("formulario-libros:mensaje_emergente",
                "formulario-libros:tabla-libros");
        this.libroSeleccionado = null;
    }

    public void eliminarLibros(){
        logger.info("Libro a eliminar: "+this.libroSeleccionado);
        this.libroService.eliminarLibro(libroSeleccionado);
        this.libros.remove(libroSeleccionado);
        this.libroSeleccionado=null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Libro eliminado"));
        PrimeFaces.current().ajax().update("formulario-libros:mensaje_emergente",
                "formulario-libros:tabla-libros");
    }
}


