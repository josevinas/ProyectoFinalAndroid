package com.example.practicafinalandroid_josevinas_paulacabello.entidades;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "usuario")
public class Usuario {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "nombre")
    private String nombre;

    @NonNull
    @ColumnInfo(name = "contrasena")
    private String contrasena;

    @NonNull
    @ColumnInfo(name = "canciones")
    private ArrayList<Cancion> lista;

    public Usuario(String nombre, String contrasena, ArrayList<Cancion> lista) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.lista = lista;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public ArrayList<Cancion> getLista() {
        return lista;
    }
}
