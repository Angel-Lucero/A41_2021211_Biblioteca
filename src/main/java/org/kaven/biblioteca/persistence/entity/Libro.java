package org.kaven.biblioteca.persistence.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "Libros")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Integer idlibro;

    @Column(name = "id_genero")
    private Integer idgenero;

    @Column(name = "id_ubicacion")
    private Integer idubicacion;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "autor")
    private String autor;

    @Column(name = "cantidad")
    private Integer cantidad;
}