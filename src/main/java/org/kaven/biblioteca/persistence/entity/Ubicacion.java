package org.kaven.biblioteca.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "Ubicacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Ubicacion {

    @Id
    @GeneratedValue
    @Column(name = "id_ubicacion")
    private Integer idUbicacion;

    @Column(name = "edificio")
    private String edificio;

    @Column(name = "sala")
    private String sala;

    @Column(name = "estante")
    private String estante;

    @Column(name = "fila")
    private String fila;

    @Column(name = "columna")
    private String columna;
}
