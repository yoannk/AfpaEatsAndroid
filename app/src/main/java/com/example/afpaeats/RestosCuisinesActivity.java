package com.example.afpaeats;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.afpaeats.Adapters.SectionsPagerAdapter;

public class RestosCuisinesActivity extends AppCompatActivity {

    Context context;
    SectionsPagerAdapter sectionsPagerAdapter;
    ViewPager viewPager;
    TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restos_cuisines);
        context = this;

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        initToolbar();
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);

        // on remplace l'actionbar par notre toolbar
        setSupportActionBar(toolbar);

        // on supprime le titre de l'application
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // j'ajoute un logo(drawable) dans la toolbar
        toolbar.setLogo(R.drawable.ic_launcher_background);

        // je definis le titre de la toolbar
        toolbar.setTitle("AFPA Eats");

        toolbar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            }
        });
    }
}