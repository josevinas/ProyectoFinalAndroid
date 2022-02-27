package com.example.practicafinalandroid_josevinas_paulacabello.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.practicafinalandroid_josevinas_paulacabello.R;
import com.example.practicafinalandroid_josevinas_paulacabello.entidades.Cancion;

import java.util.List;
import java.util.Objects;

public class ReproductorFragment extends Fragment {

    private ImageView cerrar;
    private ImageView play;
    private ImageView pause;
    private MediaPlayer mp;
    private int posicion;
    private boolean boolPause = false;

    private ListaMusicaFragment listaMusicaFragment;
    private List<Cancion> listaCanciones;
    private static TextView nombreCancion;
    private String nombreMp3;

    public ReproductorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_reproductor, container, false);

        nombreCancion = view.findViewById(R.id.tv_nombreCancionReproductor);

        listaMusicaFragment = new ListaMusicaFragment();
        listaCanciones = listaMusicaFragment.leerListaCanciones();

        cerrar = view.findViewById(R.id.img_close);
        play = view.findViewById(R.id.img_play);
        pause = view.findViewById(R.id.img_pause);

        mp = new MediaPlayer();
        detener(view);
        destruir();

//        for (Cancion c : listaCanciones) {
//            if (nombreCancion.getText().toString().equals(c.getNombre())) {
//                nombreMp3 = c.getMp3();
//            }
//        }
//        iniciar(nombreMp3);

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play.setColorFilter(Color.WHITE);
                pause.setColorFilter(Color.WHITE);
//                mp = new MediaPlayer();
                // Si inicio otra cancion solapa con la anterior
                View frag = getActivity().findViewById(R.id.fragmentoReproduce);
                frag.setVisibility(View.INVISIBLE);

//                if (mp != null) {
//                    mp.stop();
//                    posicion = 0;
//                }
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play.setColorFilter(Color.GREEN);
                pause.setColorFilter(Color.WHITE);

                iniciar(obtenerNombre(), view);
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause.setColorFilter(Color.RED);
                play.setColorFilter(Color.WHITE);
                pausar();
            }
        });
        return view;
    }

    public void destruir() {
        if (boolPause = true) {
            mp.release();
            boolPause = false;
        }
//        if (mp != null) {
//            mp.release();
//            boolPause = false;
//        }
    }

    public void iniciar(String nombreMp3, View view) {
        if (!boolPause) {
            Uri datosCancion = Uri.parse(Objects.requireNonNull(getContext()).getExternalFilesDir(null).toString() + "/" + nombreMp3);
            mp = MediaPlayer.create(getContext(), datosCancion);
            mp.start();
        } else {
            continuar(view);
        }
    }

    public void pausar() {
        if (mp != null && mp.isPlaying()) {
            posicion = mp.getCurrentPosition();
            mp.pause();
            boolPause = true;
        }
    }

    public void continuar(View view) {
        if (mp != null && !mp.isPlaying()) {
            mp.seekTo(posicion);
            mp.start();
        }
    }

    public void detener(View view) {
        if (mp != null) {
            mp.stop();
            posicion = 0;
            boolPause = false;
        }
    }

    public String obtenerNombre() {
        for (Cancion c : listaCanciones) {
            if (nombreCancion.getText().toString().equals(c.getNombre())) {
                nombreMp3 = c.getMp3();
            }
        }
        return nombreMp3;
    }
}
