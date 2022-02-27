package com.example.practicafinalandroid_josevinas_paulacabello.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.practicafinalandroid_josevinas_paulacabello.R;

public class MusicaFragment extends Fragment {

    FragmentManager fragmentManager;

    public MusicaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_musica, container, false);

        ListaMusicaFragment listaMusicaFragment = new ListaMusicaFragment();
        ReproductorFragment reproductorFragment = new ReproductorFragment();

        fragmentManager = getActivity().getSupportFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.fragmentoList, listaMusicaFragment).commit();
        fragmentManager.beginTransaction().replace(R.id.fragmentoReproduce, reproductorFragment).commit();

        return view;
    }
}
