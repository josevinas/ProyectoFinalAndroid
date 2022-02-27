package com.example.practicafinalandroid_josevinas_paulacabello;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.practicafinalandroid_josevinas_paulacabello.roomDataBase.UsuarioDataBase;

public class ModificarActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nombreUsuario, contrasena;
//    private Button btnModifica, btnCancelar;

    private static String nombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        Intent intent = getIntent();
        nombre = intent.getStringExtra("nombre");

        nombreUsuario = findViewById(R.id.campoUsuario);
        contrasena = findViewById(R.id.campoContrasena);
//        btnModifica = findViewById(R.id.btnModificaActivity);
//        btnCancelar = findViewById(R.id.btnCancelar);

//        btnModifica.setOnClickListener(this);
//        btnCancelar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnModificaActivity:
                if (!camposVacios())
                    mostrarAlert();
                break;
            case R.id.btnCancelar:
                Intent intent = new Intent(ModificarActivity.this, PestanasActivity.class);
                intent.putExtra("nombre", nombre);
                startActivity(intent);
                break;
        }
    }

    private void mostrarAlert() {
        new AlertDialog.Builder(this)
                .setTitle("¿Está seguro de que desea eliminar el usuario?")
                .setPositiveButton("MODIFICAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        modificar(nombre);
                    }
                })
                .setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setCancelable(false).create().show();
    }

    private void modificar(String nombre) {
        UsuarioDataBase usuarioDataBase = Room.databaseBuilder(this, UsuarioDataBase.class, "usuarios.db").allowMainThreadQueries().build();
        usuarioDataBase.usuarioDAO().updateUser(nombreUsuario.getText().toString(), contrasena.getText().toString(), nombre);

        Intent intent = new Intent(this, PestanasActivity.class);
        intent.putExtra("nombre", nombreUsuario.getText().toString());
        startActivity(intent);
    }

    private boolean camposVacios() {
        if (nombreUsuario.getText().toString().equals("") && contrasena.getText().toString().equals("")) {
            nombreUsuario.setError("Introduzca un valor");
            contrasena.setError("Introduzca un valor");
            return true;
        }
        else if (nombreUsuario.getText().toString().equals("")) {
            nombreUsuario.setError("Introduzca un valor");
            return true;
        }
        else if (contrasena.getText().toString().equals("")) {
            contrasena.setError("Introduzca un valor");
            return true;
        }
        return false;
    }
}