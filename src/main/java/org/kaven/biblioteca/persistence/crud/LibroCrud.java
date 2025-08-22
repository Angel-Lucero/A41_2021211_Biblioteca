package org.kaven.biblioteca.persistence.crud;

import org.kaven.biblioteca.persistence.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroCrud extends JpaRepository<Libro, Integer> {
}
