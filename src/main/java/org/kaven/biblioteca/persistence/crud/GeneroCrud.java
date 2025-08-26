package org.kaven.biblioteca.persistence.crud;

import org.kaven.biblioteca.persistence.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroCrud extends JpaRepository<Genero, Integer> {
}
