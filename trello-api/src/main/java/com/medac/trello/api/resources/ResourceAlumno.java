package com.medac.trello.api.resources;

import com.medac.trello.api.model.Alumno;
import com.medac.trello.api.model.Curso;
import com.medac.trello.api.view.AlumnoView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import static java.util.UUID.randomUUID;


@RestController
@RequestMapping("/alumno")
public class ResourceAlumno implements TrelloApi {

    @GetMapping("/{id}")
    public AlumnoView getAlumno(@PathVariable UUID id) {
        return new Alumno(id, "Liz", "Bonilla", Set.of(
                new Curso(randomUUID(),
                        "Desarrollo de Aplicaciones Web",
                        LocalDate.of(2023, 9, 9),
                        LocalDate.of(2025,12, 21))));
    }
}
