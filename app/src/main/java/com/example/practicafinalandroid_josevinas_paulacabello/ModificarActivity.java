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
import android.widget.Toast;

import com.example.practicafinalandroid_josevinas_paulacabello.roomDataBase.UsuarioDataBase;

public class ModificarActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nombreUsuario, contrasena;
    private Button btnModifica, btnCancelar;

    private static String nombre;

    private UsuarioDataBase usuarioDataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        Intent intent = getIntent();
        nombre = intent.getStringExtra("nombre");

        nombreUsuario = findViewById(R.id.campoUsuario);
        contrasena = findViewById(R.id.campoContrasena);
        btnModifica = findViewById(R.id.btnModificaActivity);
        btnCancelar = findViewById(R.id.btnCancelar);

        btnModifica.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);

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
                .setTitle(R.string.txt_alert_modify)
                .setPositiveButton(R.string.btn_Confirmar_modifica, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        modificar(nombre);
                    }
                })
                .setNegativeButton(R.string.btn_cancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setCancelable(false).create().show();
    }

    private void modificar(String nombre) {

        usuarioDataBase = Room.databaseBuilder(this, UsuarioDataBase.class, "usuarios.db").allowMainThreadQueries().build();

        usuarioDataBase.usuarioDAO().updateUser(nombreUsuario.getText().toString(), contrasena.getText().toString(), nombre);

        Intent intent = new Intent(this, PestanasActivity.class);
        intent.putExtra("nombre", nombreUsuario.getText().toString());
        startActivity(intent);
    }

    private boolean camposVacios() {

        String texto_mensaje = getApplicationContext().getResources().getString(R.string.error_camposVacios);

        if (nombreUsuario.getText().toString().equals("") && contrasena.getText().toString().equals("")) {
            nombreUsuario.setError(texto_mensaje);
            contrasena.setError(texto_mensaje);
            return true;
        } else if (nombreUsuario.getText().toString().equals("")) {
            nombreUsuario.setError(texto_mensaje);
            return true;
        } else if (contrasena.getText().toString().equals("")) {
            contrasena.setError(texto_mensaje);
            return true;
        }
        return false;
    }
}