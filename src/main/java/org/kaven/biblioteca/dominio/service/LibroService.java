package org.kaven.biblioteca.dominio.service;

import org.kaven.biblioteca.persistence.crud.LibroCrud;
import org.kaven.biblioteca.persistence.entity.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class LibroService implements ILibroService{
    @Autowired
    private LibroCrud crud;


    @Override
    public List<Libro> listarLibros() {
        List<Libro> libros = crud.findAll();
        return libros;
    }

    @Override
    public Libro buscarLibroPorId(Integer codigo) {
        Libro libros = crud.findById(codigo).orElse(null);
        return libros;
    }

    @Override
    public void guardarLibro(Libro cliente) {
        crud.save(cliente);
    }

    @Override
    public void eliminarLibro(Libro cliente) {
        crud.delete(cliente);
    }
}
