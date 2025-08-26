package org.kaven.biblioteca.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;


@Entity(name = "Genero")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Genero {

    @Id
    @GeneratedValue
    @Column(name = "id_genero")
    private Integer idgenero;

    @Column(name = "tipogGenero")
    private String tipogGenero;

    @Column(name = "descripcionGenero")
    private String descripcionGenero;


}
