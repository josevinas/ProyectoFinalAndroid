package com.example.practicafinalandroid_josevinas_paulacabello.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.practicafinalandroid_josevinas_paulacabello.fragment.MusicaFragment;
import com.example.practicafinalandroid_josevinas_paulacabello.fragment.UsuarioFragment;

public class FragmentsAdapter extends FragmentStateAdapter {

    public FragmentsAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1)
            return new MusicaFragment();
        else
            return new UsuarioFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}