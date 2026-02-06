package com.alura.forohub.dto;

import com.alura.forohub.model.StatusTopico;
import com.alura.forohub.model.Topico;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        StatusTopico estado,
        String autor,
        String curso

) {
    public DatosListadoTopico(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}
