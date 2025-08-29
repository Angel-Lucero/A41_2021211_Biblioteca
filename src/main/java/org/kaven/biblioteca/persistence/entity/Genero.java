package org.kaven.biblioteca.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;


@Entity(name = "Generos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToStringa
@EqualsAndHashCode
public class Genero {

    @Id
    @GeneratedValue
    @Column(name = "id_genero")
    private Integer idgenero;

    @Column(name = "tipo_genero")
    private String tipogGenero;

    @Column(name = "descripcion_genero")
    private String descripcionGenero;


}
