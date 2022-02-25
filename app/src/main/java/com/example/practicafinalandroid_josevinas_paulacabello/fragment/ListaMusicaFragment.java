package com.example.practicafinalandroid_josevinas_paulacabello.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practicafinalandroid_josevinas_paulacabello.MainActivity;
import com.example.practicafinalandroid_josevinas_paulacabello.R;
import com.example.practicafinalandroid_josevinas_paulacabello.adapter.MusicaAdapter;
import com.example.practicafinalandroid_josevinas_paulacabello.entidades.Cancion;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class ListaMusicaFragment extends Fragment {

    private RecyclerView recycler;
    //private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    TextView nombreCancionReproductor;

    private List<Cancion> canciones;

    public ListaMusicaFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_musica, container, false);

        //Se inicializan los objetos cancion
        canciones = new ArrayList<>();

        rellenarDatos();

        //Se obtiene el recycler
        recycler = (RecyclerView) view.findViewById(R.id.recyclerMusica);
        recycler.setHasFixedSize(true);

        //Usar un administrados para LinearLayout
        layoutManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(layoutManager);

        //Crear un nuevo adapter
        MusicaAdapter adapter = new MusicaAdapter(canciones, getContext());

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombreCancionReproductor = getActivity().findViewById(R.id.tv_nombreCancionReproductor);
                nombreCancionReproductor.setText(canciones.get(recycler.getChildAdapterPosition(view)).getNombre());
                View frag = getActivity().findViewById(R.id.fragmentoReproduce);
                frag.setVisibility(View.VISIBLE);
            }
        });

        recycler.setAdapter(adapter);

        return view;
    }

    private void rellenarDatos() {
        canciones.add(new Cancion(R.drawable.como_camaron, "Como Camarón", "Estopa"));
        canciones.add(new Cancion(R.drawable.como_camaron, "Como Camarón", "Estopa"));
        canciones.add(new Cancion(R.drawable.como_camaron, "Como Camarón", "Estopa"));
        canciones.add(new Cancion(R.drawable.como_camaron, "Como Camarón", "Estopa"));
        canciones.add(new Cancion(R.drawable.como_camaron, "Como Camarón", "Estopa"));
        canciones.add(new Cancion(R.drawable.como_camaron, "Como Camarón", "Estopa"));
        canciones.add(new Cancion(R.drawable.corazon_partio, "Corazón Partío", "Alejandroi Sanz"));
        canciones.add(new Cancion(R.drawable.princesas, "Princesas", "Pereza"));
    }
}
