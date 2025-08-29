package org.kaven.biblioteca.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.kaven.biblioteca.dominio.service.IGeneroService;
import org.kaven.biblioteca.persistence.entity.Genero;
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

    public void agregarCliente(){
        this.generoSeleccionado = new Genero();
    }
}
