package com.example.practicafinalandroid_josevinas_paulacabello.dao;

//import androidx.lifecycle.LiveData;
//import androidx.room.Dao;
//import androidx.room.Delete;
//import androidx.room.Insert;
//import androidx.room.OnConflictStrategy;
//import androidx.room.Query;
//import androidx.room.Update;
//
//import com.example.practicafinalandroid_josevinas_paulacabello.entidades.Cancion;
//import com.example.practicafinalandroid_josevinas_paulacabello.entidades.Usuario;
//
//import java.util.List;
//
//@Dao
//public interface CancionDAO {
//
//    // Insertar canción
//    @Insert
//    void insert(Cancion cancion);
//
//    // Leer todas las canciones
//    @Query("SELECT * FROM cancion")
//    LiveData<List<Cancion>> lista();
//
//    // Leer canción
//    @Query("SELECT * FROM cancion WHERE nombre LIKE :nombre LIMIT 1")
//    Cancion readByNom(String nombre);
//
//    // Eliminar canción
//    @Delete
//    void delete(Cancion cancion);
//
//    // Actualizar canción
//    @Update
//    void update(Cancion cancion);
//}
