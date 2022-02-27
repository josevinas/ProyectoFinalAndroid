package com.example.practicafinalandroid_josevinas_paulacabello.entidades;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class Cancion {

    private String nombre;

    private String autor;

    private String mp3;

    private int imagen;

    public Cancion(int imagen, String nombre, String autor, String mp3) {
        this.nombre = nombre;
        this.autor = autor;
        this.imagen = imagen;
        this.mp3 = mp3;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getMp3() {
        return mp3;
    }
}