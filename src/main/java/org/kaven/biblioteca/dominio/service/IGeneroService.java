package org.kaven.biblioteca.dominio.service;

import org.kaven.biblioteca.persistence.entity.Genero;

import java.util.List;

public interface IGeneroService {
    List<Genero> listarGeneros();
    Genero buscarGeneroPorId(Integer codigo);
    void guardarGenero(Genero genero);
    void eliminarGenero(Genero genero);
}
