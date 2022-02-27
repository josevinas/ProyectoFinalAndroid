package com.example.practicafinalandroid_josevinas_paulacabello;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practicafinalandroid_josevinas_paulacabello.entidades.Usuario;
import com.example.practicafinalandroid_josevinas_paulacabello.roomDataBase.UsuarioDataBase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText campoNombre, campoContrasena;

    private UsuarioDataBase usuarioDataBase;
    private Usuario usuario;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNombre = findViewById(R.id.campoUsuario);
        campoContrasena = findViewById(R.id.campoContrasena);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.botonEntrar:
                iniciarSesión();
                break;
            case R.id.botonRegistrar:
                registrarUsuario();
                break;
        }
    }

    private void iniciarSesión() {
        if (campoNombre.getText().toString().equals("") || campoContrasena.getText().toString().equals("")) {
            alertDialog();
        } else {
            usuarioDataBase = Room.databaseBuilder(getApplicationContext(), UsuarioDataBase.class, "usuarios.db").allowMainThreadQueries().build();
            usuario = usuarioDataBase.usuarioDAO().getByName(campoNombre.getText().toString());

            if (usuario == null) {
                Toast.makeText(this, R.string.usuario_noRegistrado_Toast, Toast.LENGTH_SHORT).show();
            } else if (!usuario.getContrasena().equals(campoContrasena.getText().toString())) {
                Toast.makeText(this, R.string.contraseña_incorrecta_Toast, Toast.LENGTH_SHORT).show();
                campoContrasena.setText("");
            } else {
                String nombreUsu = usuario.getNombre();
                cambiarActividad(nombreUsu);
            }
        }
    }

    private void registrarUsuario() {
        if (campoNombre.getText().toString().equals("") || campoContrasena.getText().toString().equals("")) {
            alertDialog();
        } else {
            usuarioDataBase = Room.databaseBuilder(getApplicationContext(), UsuarioDataBase.class, "usuarios.db").allowMainThreadQueries().build();
            usuario = new Usuario(campoNombre.getText().toString(), campoContrasena.getText().toString());
            try {
                usuarioDataBase.usuarioDAO().insert(usuario);
                Toast.makeText(this, R.string.registroCorrecto_Toast, Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast toast = new Toast(getApplicationContext());
                LayoutInflater inflater = getLayoutInflater();
                View v = inflater.inflate(R.layout.toast_duplicado, (ViewGroup) findViewById(R.id.toast_duplicado));
                TextView txt = (TextView) v.findViewById(R.id.txtMensaje);
                txt.setText(R.string.error_usuario_duplicado);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.setView(v);
                toast.show();
                campoNombre.setText("");
                campoContrasena.setText("");
                e.printStackTrace();
            }
        }
    }

    private void cambiarActividad(String nombreUsu) {
        Intent intent = new Intent(MainActivity.this, PestanasActivity.class);
        intent.putExtra("nombre", nombreUsu);
        startActivity(intent);
    }

    // LLamamos al método alertDialog() en caso de que algún campo requerido se encuentre vacío
    public void alertDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.txt_error_alert)
                .setMessage(R.string.txt_alert)
                .setPositiveButton(R.string.btn_entendido_alert, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton(R.string.btn_cancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        campoNombre.setText("");
                        campoContrasena.setText("");
                    }
                })
                .setCancelable(false).create().show();
    }
}