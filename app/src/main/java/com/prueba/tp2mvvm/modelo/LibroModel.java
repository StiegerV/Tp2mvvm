package com.prueba.tp2mvvm.modelo;

import java.io.Serializable;

public class LibroModel implements Serializable {

    private String  descripcion, autor,titulo;
    private int imagen;


    public LibroModel(String descripcion, String autor, String titulo, int imagen) {
        this.descripcion = descripcion;
        this.autor = autor;
        this.titulo = titulo;
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
