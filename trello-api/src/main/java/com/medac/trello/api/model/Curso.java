package com.medac.trello.api.model;

import java.time.LocalDate;
import java.util.UUID;

public class Curso {

    public final UUID id;
    public final String titulo;
    public final LocalDate inicio;
    public final LocalDate fin;

    public Curso(UUID id, String titulo, LocalDate inicio, LocalDate fin) {
        this.id = id;
        this.titulo = titulo;
        this.inicio = inicio;
        this.fin = fin;
    }
}
