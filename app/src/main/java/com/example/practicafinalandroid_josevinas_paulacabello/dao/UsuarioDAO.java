package com.example.practicafinalandroid_josevinas_paulacabello.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.practicafinalandroid_josevinas_paulacabello.entidades.Usuario;


@Dao
public interface UsuarioDAO {

    // Insertar Usuario
    @Insert
    void insert(Usuario usuario);

    // Leer Usuario
    @Query("SELECT * FROM usuario WHERE nombre = :nombre")
    Usuario getByName(String nombre);

    @Query("UPDATE usuario SET nombre = :nombre, contrasena = :contrasena WHERE nombre = :nombreModifica")
    int updateUser(String nombre, String contrasena, String nombreModifica);

    // Eliminar Usuario
    @Delete
    void delete(Usuario usuario);

    // Actualizar Usuario
    @Update
    void update(Usuario usuario);
}
