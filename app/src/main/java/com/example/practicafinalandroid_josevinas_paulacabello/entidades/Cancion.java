package com.example.practicafinalandroid_josevinas_paulacabello.entidades;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cancion")
public class Cancion {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "nombre")
    private String nombre;

    @NonNull
    @ColumnInfo(name = "autor")
    private String autor;

    @ColumnInfo(name = "imagen")
    private int imagen;

    public Cancion (int imagen, String nombre, String autor) {
        this.nombre = nombre;
        this.autor = autor;
        this.imagen = imagen;
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
}