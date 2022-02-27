package com.example.practicafinalandroid_josevinas_paulacabello.fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.practicafinalandroid_josevinas_paulacabello.MainActivity;
import com.example.practicafinalandroid_josevinas_paulacabello.ModificarActivity;
import com.example.practicafinalandroid_josevinas_paulacabello.PestanasActivity;
import com.example.practicafinalandroid_josevinas_paulacabello.R;
import com.example.practicafinalandroid_josevinas_paulacabello.entidades.Usuario;
import com.example.practicafinalandroid_josevinas_paulacabello.roomDataBase.UsuarioDataBase;

public class UsuarioFragment extends Fragment implements View.OnClickListener {

    private TextView tv_nombre;
    private Button btnModificar, btnEliminar;
    private UsuarioDataBase usuarioDataBase;

    public UsuarioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_usuario, container, false);

        tv_nombre = view.findViewById(R.id.tv_nombre);
        btnEliminar = view.findViewById(R.id.btn_eliminar);
        btnModificar = view.findViewById(R.id.btnModificaFragment);

        PestanasActivity pestanasActivity = new PestanasActivity();
        String nombre = pestanasActivity.getNombre();
        tv_nombre.setText(nombre);

        btnModificar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);

        return view;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnModificaFragment:
                modificarUsuario(tv_nombre.getText().toString());
                break;
            case R.id.btn_eliminar:
                mostrarAlert();
                break;
        }
    }

    private void mostrarAlert() {
        new AlertDialog.Builder(getContext())
                .setTitle("¿Está seguro de que desea realizar esta acción?")
                .setPositiveButton("CONTINUAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        eliminarUsuario(tv_nombre.getText().toString());
                    }
                })
                .setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setCancelable(false).create().show();
    }

    private void modificarUsuario(String nombre) {
        Intent intent = new Intent(getContext(), ModificarActivity.class);
        intent.putExtra("nombre", nombre);
        startActivity(intent);
    }

    private void eliminarUsuario(String nombre) {
        usuarioDataBase = Room.databaseBuilder(getContext(), UsuarioDataBase.class, "usuarios.db").allowMainThreadQueries().build();
        Usuario usuarioEliminar = usuarioDataBase.usuarioDAO().getByName(nombre);
        usuarioDataBase.usuarioDAO().delete(usuarioEliminar);
        Intent intent = new Intent(getContext(), MainActivity.class);
        startActivity(intent);
    }
}