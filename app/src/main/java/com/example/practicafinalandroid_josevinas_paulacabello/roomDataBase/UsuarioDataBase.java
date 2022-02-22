package com.example.practicafinalandroid_josevinas_paulacabello.roomDataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.practicafinalandroid_josevinas_paulacabello.dao.UsuarioDAO;
import com.example.practicafinalandroid_josevinas_paulacabello.entidades.Usuario;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Usuario.class}, version = 1, exportSchema = false)
public abstract class UsuarioDataBase extends RoomDatabase {

    public abstract UsuarioDAO usuarioDAO();

//    private static final String DATABASE_NAME = "musica-db";
//    private static UsuarioDataBase INSTANCE;
//    private static final int THREADS = 4;
//
//    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(THREADS);
//
//    public static UsuarioDataBase getInstance(final Context context) {
//        if (INSTANCE == null) {
//            synchronized (UsuarioDataBase.class) {
//                if (INSTANCE == null) {
//                    INSTANCE = Room.databaseBuilder( context.getApplicationContext(), UsuarioDataBase.class, DATABASE_NAME).build();
//                }
//            }
//        }
//        return INSTANCE;
//    }
}