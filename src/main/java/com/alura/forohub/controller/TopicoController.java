package com.alura.forohub.controller;

import com.alura.forohub.dto.DatosListadoTopico;
import com.alura.forohub.dto.DatosRegistroTopico;
import com.alura.forohub.model.StatusTopico;
import com.alura.forohub.model.Topico;
import com.alura.forohub.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoRepository repository;

    public TopicoController(TopicoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> registrarTopico(@RequestBody @Valid DatosRegistroTopico datos) {

        if (repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
            return ResponseEntity.badRequest().body("Ya existe un tópico con el mismo título y mensaje");
        }

        Topico topico = new Topico();

        topico.setTitulo(datos.titulo());
        topico.setMensaje(datos.mensaje());
        topico.setAutor(datos.autor());
        topico.setCurso(datos.curso());
        topico.setStatus(StatusTopico.ABIERTO);

        repository.save(topico);

        return ResponseEntity.ok(topico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listar(
            @PageableDefault(
                    size = 10,
                    sort = "fechaCreacion",
                    direction = Sort.Direction.ASC
            ) Pageable pageable
    ) {
        var page = repository.findAll(pageable)
                .map(DatosListadoTopico::new);

        return ResponseEntity.ok(page);
    }
}
