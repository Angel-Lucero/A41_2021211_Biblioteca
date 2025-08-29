package org.kaven.biblioteca.dominio.service;


import org.kaven.biblioteca.persistence.entity.Ubicacion;

import java.util.List;

public interface IUbicacionService {
    List<Ubicacion> listarUbicaciones();
    Ubicacion buscarUbicacionPorId(Integer codigo);
    void guardarUbicacion(Ubicacion ubicacion);
    void eliminarUbicacion(Ubicacion ubicacion);
}
