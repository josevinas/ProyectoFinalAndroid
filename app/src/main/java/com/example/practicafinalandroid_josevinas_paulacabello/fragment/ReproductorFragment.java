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
    private static List<Cancion> listaCanciones;
    private static TextView nombreCancion;
    private static String nombreMp3;

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

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detener();
                destruir();
                boolPause = false;

                View frag = getActivity().findViewById(R.id.fragmentoReproduce);
                frag.setVisibility(View.GONE);
                View frag2 = getActivity().findViewById(R.id.fragmentoList);
                frag2.setVisibility(View.VISIBLE);

            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boolPause) {
                    continuar();
                    play.setColorFilter(Color.GREEN);
                    pause.setColorFilter(Color.WHITE);
                } else
                    iniciar();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pausar();
            }
        });

        return view;
    }

    public void iniciar() {
        destruir();

        play.setColorFilter(Color.GREEN);
        pause.setColorFilter(Color.WHITE);

        Uri datos = Uri.parse(Objects.requireNonNull(getContext()).getExternalFilesDir(null).toString() + "/" + obtenerNombre());
        mp = MediaPlayer.create(getContext(), datos);
        mp.start();


    }

    public void destruir() {

        if (mp != null)
            mp.release();

    }

    public void pausar() {

        pause.setColorFilter(Color.RED);
        play.setColorFilter(Color.WHITE);

        if (mp != null && mp.isPlaying()) {
            posicion = mp.getCurrentPosition();
            mp.pause();
            boolPause = true;
        }
    }

    public void continuar() {

        if (mp != null && !mp.isPlaying()) {
            mp.seekTo(posicion);
            mp.start();
        }

    }

    public void detener() {

        if (mp != null) {
            mp.stop();
            posicion = 0;
            boolPause = false;
        }

    }

    public String obtenerNombre() {
        for (Cancion cancion : listaCanciones) {
            if (nombreCancion.getText().toString().equals(cancion.getNombre())) {
                nombreMp3 = cancion.getMp3();
            }
        }
        return nombreMp3;
    }
}
