package br.com.pellisoli.todo;

import java.time.LocalDateTime;

public class Task {

    public int id;
    public String titulo;
    public String obs;
    public LocalDateTime dateTime;


    public Task() {
    }

    public Task(int id, String titulo, String obs, LocalDateTime dateTime) {
        this.id = id;
        this.titulo = titulo;
        this.obs = obs;
        this.dateTime = dateTime;
    }
}
