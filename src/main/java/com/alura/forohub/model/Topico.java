package com.alura.forohub.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private String titulo;

    @Setter
    @Column(nullable = false)
    private String mensaje;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Setter
    @Enumerated(EnumType.STRING)
    private StatusTopico status;

    @Setter
    @Column(nullable = false)
    private String autor;

    @Setter
    @Column(nullable = false)
    private String curso;

}
