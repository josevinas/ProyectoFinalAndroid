package com.example.practicafinalandroid_josevinas_paulacabello;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.room.Database;
import androidx.room.Room;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practicafinalandroid_josevinas_paulacabello.entidades.Cancion;
import com.example.practicafinalandroid_josevinas_paulacabello.entidades.Usuario;
import com.example.practicafinalandroid_josevinas_paulacabello.roomDataBase.UsuarioDataBase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText campoUsuario, campoContrasena;

    private UsuarioDataBase usuarioDataBase;
    private Usuario usu;
    private String usuario, contrasena;
    private Toast toast;
    private boolean existeUsuario;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoUsuario = findViewById(R.id.campoUsuario);
        campoContrasena = findViewById(R.id.campoContrasena);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.botonEntrar:
                usuarioDataBase = Room.databaseBuilder(getApplicationContext(), UsuarioDataBase.class, "usuarios.db").allowMainThreadQueries().build();
                usuario = campoUsuario.getText().toString();
                contrasena = campoContrasena.getText().toString();

                if (usuario.equals("") || contrasena.equals("")) {
                    alertDialog();
                }
                else {
//                    existeUsuario = false;
                    if (usuarioDataBase.usuarioDAO().readName(usuario).equals(usuario)) {
                        intent = new Intent(MainActivity.this, MusicaActivity.class);
                        startActivity(intent);
                    }
//                    for (String n : listaNombres) {
//                        if (n.equals(usuario)) {
//                            existeUsuario = true;
//                            break;
//                        }
//                    }
                    else {
                        Toast.makeText(this, "El usuario no está registrado.", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.botonRegistrar:
                usuarioDataBase = Room.databaseBuilder(getApplicationContext(), UsuarioDataBase.class, "usuarios.db").allowMainThreadQueries().build();
                usuario = campoUsuario.getText().toString();
                contrasena = campoContrasena.getText().toString();

                if (usuario .equals("") || contrasena.equals("")) {
                    alertDialog();
                }
                else {
                    usu = new Usuario(campoUsuario.getText().toString(), campoContrasena.getText().toString());
                    try {
                        usuarioDataBase.usuarioDAO().insert(usu);
                        campoUsuario.setText("");
                        campoContrasena.setText("");
                        Toast.makeText(this, "Usuario registrado correctamente!", Toast.LENGTH_LONG).show();

                        intent = new Intent(MainActivity.this, MusicaActivity.class);
                        startActivity(intent);
                    }
                    catch (Exception e) {
                        toast = new Toast(getApplicationContext());
                        LayoutInflater inflater = getLayoutInflater();
                        View v = inflater.inflate(R.layout.toast_vacio, (ViewGroup) findViewById(R.id.toast_vacio));
                        TextView txt = (TextView) v.findViewById(R.id.txtMensaje);
                        txt.setText("ERROR - USUARIO DUPLICADO");
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.setView(v);
                        toast.show();
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    // LLamamos al método alertDialog() en caso de que algún campo requerido se encuentre vacío
    public void alertDialog() {
        new AlertDialog.Builder(this)
                .setTitle("ERROR")
                .setMessage("Algún campo requerido se encuentra vacío.\nIntroduzca los datos necesarios.")
                .setPositiveButton("ENTENDIDO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        campoUsuario.setText("");
                        campoContrasena.setText("");
                    }
                })
                .setCancelable(false).create().show();
    }
}