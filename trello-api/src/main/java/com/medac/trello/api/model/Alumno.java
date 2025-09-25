package com.medac.trello.api.model;

import com.medac.trello.api.view.AlumnoView;

import java.util.Set;
import java.util.UUID;

public class Alumno implements AlumnoView {

    public final UUID id;
    public final String name;
    public final String surname;
    public final Set<Curso> cursos;

    public Alumno(UUID id, String name, String surname, Set<Curso> cursos) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.cursos = cursos;
    }
}
