package org.kaven.biblioteca.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.kaven.biblioteca.dominio.service.IUbicacionService;
import org.kaven.biblioteca.persistence.entity.Libro;
import org.kaven.biblioteca.persistence.entity.Ubicacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ViewScoped
public class UbicacionesController {
    @Autowired
    IUbicacionService ubicacionService;
    private List<Ubicacion> ubicaciones;
    private Ubicacion ubicacionesSeleccionadas;
    private static final Logger logger = LoggerFactory.getLogger(UbicacionesController.class);

    @PostConstruct
    public void init(){
        cargarDatos();
    }

    public void cargarDatos(){
        this.ubicaciones = this.ubicacionService.listarUbicaciones();
        this.ubicaciones.forEach(ubicacion -> logger.info(ubicacion.toString()));
    }

    public void agregarCliente(){
        this.ubicacionesSeleccionadas = new Ubicacion();
    }
}
