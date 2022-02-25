package com.example.practicafinalandroid_josevinas_paulacabello.fragment;

import android.content.Intent;
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

public class ReproductorFragment extends Fragment {

    private ImageView cerrar;
    private ImageView play;
    private ImageView pause;

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

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View frag = getActivity().findViewById(R.id.fragmentoReproduce);
                frag.setVisibility(View.INVISIBLE);


            }
        });

        /*play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play.setColorFilter(R.color.cardview_light_background);
            }
        });*/


        return view;
    }
}
