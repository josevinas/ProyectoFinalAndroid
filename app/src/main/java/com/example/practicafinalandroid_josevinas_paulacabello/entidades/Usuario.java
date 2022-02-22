package com.example.practicafinalandroid_josevinas_paulacabello.entidades;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "usuario")
public class Usuario {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "nombre")
    private final String nombre;

    @NonNull
    @ColumnInfo(name = "contrasena")
    private final String contrasena;

    public Usuario(@NonNull String nombre, @NonNull String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }
}
