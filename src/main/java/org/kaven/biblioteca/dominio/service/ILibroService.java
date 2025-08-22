package org.kaven.biblioteca.dominio.service;

import org.kaven.biblioteca.persistence.entity.Libro;

import java.util.List;

public interface ILibroService {
    List<Libro> listarLibros();
    Libro buscarLibroPorId(Integer codigo);
    void guardarLibro(Libro libro);
    void eliminarLibro(Libro libro);
}
