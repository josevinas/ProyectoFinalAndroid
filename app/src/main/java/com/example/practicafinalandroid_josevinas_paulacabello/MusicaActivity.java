package com.example.practicafinalandroid_josevinas_paulacabello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.practicafinalandroid_josevinas_paulacabello.R;
import com.example.practicafinalandroid_josevinas_paulacabello.entidades.Cancion;
import com.example.practicafinalandroid_josevinas_paulacabello.fragment.ListaMusicaFragment;
import com.example.practicafinalandroid_josevinas_paulacabello.fragment.ReproductorFragment;

public class MusicaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);

        FrameLayout fragmentoLista = findViewById(R.id.fragmentoList);
        FrameLayout fragmentoReproductor = findViewById(R.id.fragmentoReproduce);

        ListaMusicaFragment listaMusicaFragment = new ListaMusicaFragment();
        ReproductorFragment reproductorFragment = new ReproductorFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentoList, listaMusicaFragment).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentoReproduce, reproductorFragment).commit();

//        Cancion cancion = (Cancion) getIntent().getSerializableExtra("datos");
//        /*fl2.setVisibility(View.VISIBLE);*/

    }
}