package com.example.practicafinalandroid_josevinas_paulacabello.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.practicafinalandroid_josevinas_paulacabello.entidades.Usuario;

import java.util.List;

@Dao
public interface UsuarioDAO {

    // Insertar Usuario
    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insert(Usuario usuario);

    // Leer Usuario
    @Query("SELECT * FROM usuario WHERE nombre LIKE :nombre LIMIT 1")
    Usuario readByCod(String nombre);

    // Eliminar Usuario
    @Delete
    void delete(Usuario usuario);

    // Actualizar Usuario
    @Update
    void update(Usuario usuario);
}
