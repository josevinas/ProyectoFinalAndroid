package com.example.practicafinalandroid_josevinas_paulacabello.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.practicafinalandroid_josevinas_paulacabello.R;
import com.example.practicafinalandroid_josevinas_paulacabello.entidades.Cancion;

public class ReproductorFragment extends Fragment {

    private ImageView cerrar;
    private ImageView play;
    private ImageView pause;
    private MediaPlayer mp;
    private int posicion;
    private ProgressBar progressBar;
    private boolean boolPause = false;

    public ReproductorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_reproductor, container, false);

        cerrar = view.findViewById(R.id.img_close);
        play = view.findViewById(R.id.img_play);
        pause = view.findViewById(R.id.img_pause);
        progressBar = view.findViewById(R.id.progressBar);

        /*cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View frag = getActivity().findViewById(R.id.fragmentoReproduce);
                frag.setVisibility(View.INVISIBLE);

                if (mp != null) {
                    mp.stop();
                    posicion = 0;
                }
            }
        });*/

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                play.setColorFilter(Color.GREEN);
                pause.setColorFilter(Color.WHITE);

                if (boolPause) {
                    if (mp != null && mp.isPlaying() == false) {
                        mp.seekTo(posicion);
                        mp.start();
                        boolPause = false;
                    }
                } else {
                    mp = MediaPlayer.create(getContext(), R.raw.como_camaron);
                    mp.start();
                    progressBar.setSecondaryProgress(100);
                    progressBar.setProgress(80);
                    progressBar.setMax(100);
                    boolPause = false;
                }
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pause.setColorFilter(Color.RED);
                play.setColorFilter(Color.WHITE);

                if (mp != null && mp.isPlaying()) {
                    posicion = mp.getCurrentPosition();
                    mp.pause();
                    boolPause = true;
                }
            }
        });

        return view;
    }
}
