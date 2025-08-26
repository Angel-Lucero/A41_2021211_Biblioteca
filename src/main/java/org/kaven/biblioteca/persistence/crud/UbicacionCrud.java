package org.kaven.biblioteca.persistence.crud;

import org.kaven.biblioteca.persistence.entity.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UbicacionCrud extends JpaRepository <Ubicacion, Integer> {
}
