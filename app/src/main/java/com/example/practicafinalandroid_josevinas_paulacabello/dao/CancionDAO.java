package com.example.practicafinalandroid_josevinas_paulacabello.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.practicafinalandroid_josevinas_paulacabello.entidades.Cancion;
import com.example.practicafinalandroid_josevinas_paulacabello.entidades.Usuario;

import java.util.List;

@Dao
public interface CancionDAO {

    @Query("SELECT * FROM cancion")
    LiveData<List<Usuario>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Cancion cancion);
}
