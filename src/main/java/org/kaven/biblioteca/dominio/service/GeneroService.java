package org.kaven.biblioteca.dominio.service;

import org.kaven.biblioteca.persistence.crud.GeneroCrud;
import org.kaven.biblioteca.persistence.entity.Genero;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GeneroService implements IGeneroService{
        @Autowired
        private GeneroCrud crud;

        @Override
        public List<Genero> listarGeneros() {
            List<Genero> generos = crud.findAll();
            return generos;
        }

        @Override
        public Genero buscarGeneroPorId(Integer codigo){
            Genero genero = crud.findById(codigo).orElse(null);
            return genero;
        }

        @Override
        public void guardarGenero(Genero genero){
            crud.save(genero);
        }

        @Override
        public void eliminarGenero(Genero genero){
            crud.delete(genero);
        }

}
