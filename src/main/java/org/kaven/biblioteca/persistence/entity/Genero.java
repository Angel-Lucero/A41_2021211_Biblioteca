package org.kaven.biblioteca.persistence.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity(name = "Generos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genero")
    private Integer idgenero;

    @Column(name = "tipo_genero")
    private String tipogGenero;

    @Column(name = "descripcion_genero")
    private String descripcionGenero;


}
