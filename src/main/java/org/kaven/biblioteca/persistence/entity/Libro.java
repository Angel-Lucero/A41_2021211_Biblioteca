package org.kaven.biblioteca.persistence.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity(name = "Libros")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdLibro;
    @Column
    private Integer IdGenero;
    private Integer IdUbicacion;
    private String titulo;
    private String autor;
    private  Integer cantidad;
}
