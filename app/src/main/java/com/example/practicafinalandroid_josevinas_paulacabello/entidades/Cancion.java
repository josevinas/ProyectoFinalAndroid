package com.example.practicafinalandroid_josevinas_paulacabello.entidades;

import android.text.format.Time;

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

    @NonNull
    @ColumnInfo(name = "duracion")
    private Time duracion;

    @ColumnInfo(name = "imagen")
    private int imagen;

    public Cancion (@NonNull String nombre, @NonNull String autor, @NonNull Time duracion, int imagen) {
        this.nombre = nombre;
        this.autor = autor;
        this.duracion = duracion;
        this.imagen = imagen;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    @NonNull
    public String getAutor() {
        return autor;
    }

    public void setAutor(@NonNull String autor) {
        this.autor = autor;
    }

    @NonNull
    public Time getDuracion() {
        return duracion;
    }

    public void setDuracion(@NonNull Time duracion) {
        this.duracion = duracion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}