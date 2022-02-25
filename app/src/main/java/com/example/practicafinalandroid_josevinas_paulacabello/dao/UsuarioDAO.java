package com.example.practicafinalandroid_josevinas_paulacabello.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.practicafinalandroid_josevinas_paulacabello.entidades.Usuario;

import java.util.List;

@Dao
public interface UsuarioDAO {

    // Insertar Usuario
    @Insert
    void insert(Usuario usuario);

    // Leer Usuario
    @Query("SELECT nombre FROM usuario WHERE nombre LIKE :name")
    String readName(String name);

    //Leer TODOS Usuarios
//    @Transaction
//    @Query("SELECT nombre FROM usuario")
//    LiveData<List<String>> readAll();

    // Eliminar Usuario
    @Delete
    void delete(Usuario usuario);

    // Actualizar Usuario
    @Update
    void update(Usuario usuario);
}
