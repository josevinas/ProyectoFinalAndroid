package com.example.practicafinalandroid_josevinas_paulacabello;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.practicafinalandroid_josevinas_paulacabello.adapter.FragmentsAdapter;
import com.google.android.material.tabs.TabLayout;

public class PestanasActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private FragmentsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pestanas);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);

        tabLayout.addTab(tabLayout.newTab().setText("Perfil"));
        tabLayout.addTab(tabLayout.newTab().setText("Canciones"));

        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new FragmentsAdapter(fragmentManager, getLifecycle());
        viewPager2.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }
}
