package org.kaven.biblioteca.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.kaven.biblioteca.dominio.service.IGeneroService;
import org.kaven.biblioteca.persistence.entity.Genero;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ViewScoped
public class GenerosController {
    @Autowired
    IGeneroService generoService;
    private List<Genero> generos;
    private Genero generoSeleccionado;
    private static final Logger logger = LoggerFactory.getLogger(GenerosController.class);

    @PostConstruct
    public void init(){
        cargarDatos();
    }

    public void cargarDatos(){
        this.generos = this.generoService.listarGeneros();
        this.generos.forEach(genero -> logger.info(genero.toString()));
    }

    public void agregarGenero(){
        this.generoSeleccionado = new Genero();
    }

    public void guardarGenero(){
        logger.info("Género a guardar: " + this.generoSeleccionado);

        if (this.generoSeleccionado.getIdgenero() == null){
            this.generoService.guardarGenero(this.generoSeleccionado);
            this.generos.add(this.generoSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Género agregado"));
        }
        else{
            this.generoService.guardarGenero(this.generoSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Género Actualizado"));
        }
        PrimeFaces.current().executeScript("PF('VentanaModalGenero').hide()");
        PrimeFaces.current().ajax().update("formulario-generos:mensaje_emergente",
                "formulario-generos:tabla-generos");
        this.generoSeleccionado = null;
    }

    public void eliminarGenero(){
        logger.info("Género a eliminar: "+this.generoSeleccionado);
        this.generoService.eliminarGenero(generoSeleccionado);
        this.generos.remove(generoSeleccionado);
        this.generoSeleccionado=null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Género eliminado"));
        PrimeFaces.current().ajax().update("formulario-generos:mensaje_emergente",
                "formulario-generos:tabla-generos");
    }
}