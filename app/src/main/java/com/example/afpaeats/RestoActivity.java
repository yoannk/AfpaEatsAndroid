package com.example.afpaeats;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.afpaeats.Adapters.ProduitsAdapter;
import com.example.afpaeats.Adapters.RestaurantsAdapter;
import com.example.afpaeats.Entities.Produit;
import com.example.afpaeats.Entities.Produits;
import com.example.afpaeats.Entities.Restaurant;
import com.example.afpaeats.Utilities.App;
import com.example.afpaeats.Utilities.Constants;
import com.example.afpaeats.Utilities.ServiceWebTask;
import com.google.gson.Gson;

import java.util.HashMap;

public class RestoActivity extends AppCompatActivity implements ServiceWebTask.InterfaceServiceWeb {

    Context context;
    RecyclerView rvwProduits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resto);
        context = this;
        Intent intent = getIntent();

        String restaurantJson = intent.getStringExtra(Constants.RESTAURANT_JSON);

        if (!restaurantJson.isEmpty()) {
            Gson gson = new Gson();
            Restaurant restaurant = gson.fromJson(restaurantJson, Restaurant.class);

            ImageView imgRestaurant = findViewById(R.id.imgRestaurant);
            TextView txtNom = findViewById(R.id.txtNom);
            TextView txtAdresse = findViewById(R.id.txtAdresse);
            TextView txtTelephone = findViewById(R.id.txtTelephone);

            txtNom.setText(restaurant.getNom());

            rvwProduits = findViewById(R.id.rvwProduits);

            HashMap<String, String> parameters = new HashMap<>();
            parameters.put("idRestaurant", "" + restaurant.getIdRestaurant());
            parameters.put("idSw", "0");

            ServiceWebTask serviceWebTask = new ServiceWebTask("GetProduits", parameters, 0, RestoActivity.this);
            serviceWebTask.execute();

        } else {
            Toast.makeText(context, "Erreur lors du chargement des informations de restaurant.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void returnSw(String value, int idSw) {
        if (!value.isEmpty()) {
            Gson gson = new Gson();

            switch (idSw) {
                case 0:
                    Produits produits = gson.fromJson(value, Produits.class);

                    //on instancie notre adapter
                    ProduitsAdapter produitsAdapter = new ProduitsAdapter(produits, context);

                    //la manière dont les adherents doivent s'afficher
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);


                    rvwProduits.setLayoutManager(layoutManager);

                    //Effet sur le recyclerView
                    DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
                    rvwProduits.setItemAnimator(defaultItemAnimator);

                    //on passe notre adapter à notre recyclerview
                    rvwProduits.setAdapter(produitsAdapter);

                    break;
            }
        }
    }
}
