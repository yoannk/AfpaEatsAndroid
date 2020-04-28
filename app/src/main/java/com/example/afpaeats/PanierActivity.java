package com.example.afpaeats;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.afpaeats.Adapters.PanierAdapter;
import com.example.afpaeats.Adapters.ProduitsAdapter;
import com.example.afpaeats.Entities.Session;

public class PanierActivity extends AppCompatActivity {

    Context _context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panier);
        _context = this;

        RecyclerView rvwPanier = findViewById(R.id.rvwPanier);

        //on instancie notre adapter
        PanierAdapter panierAdapter = new PanierAdapter(Session.getPanier(), _context);

        //la manière dont les adherents doivent s'afficher
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(_context, LinearLayoutManager.VERTICAL, false);

        rvwPanier.setLayoutManager(layoutManager);

        //Effet sur le recyclerView
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        rvwPanier.setItemAnimator(defaultItemAnimator);

        //on passe notre adapter à notre recyclerview
        rvwPanier.setAdapter(panierAdapter);
    }
}
