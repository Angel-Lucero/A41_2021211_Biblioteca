package org.kaven.biblioteca.dominio.service;

import org.kaven.biblioteca.persistence.crud.UbicacionCrud;
import org.kaven.biblioteca.persistence.entity.Ubicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbicacionService implements IUbicacionService {
    @Autowired

    private UbicacionCrud crud;
    @Override
    public List<Ubicacion> listarUbicaciones() {
        List<Ubicacion> ubicaciones = crud.findAll();
        return ubicaciones;
    }

    @Override
    public Ubicacion buscarUbicacionPorId(Integer codigo){
        Ubicacion ubicacion = crud.findById(codigo).orElse(null);
        return ubicacion;
    }

    @Override
    public void guardarUbicacion(Ubicacion ubicacion){
        crud.save(ubicacion);
    }

    @Override
    public void eliminarUbicacion(Ubicacion ubicacion){
        crud.delete(ubicacion);
    }
}
