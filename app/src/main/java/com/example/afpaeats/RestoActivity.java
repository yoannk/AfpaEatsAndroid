package com.example.afpaeats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.afpaeats.Entities.Restaurant;
import com.example.afpaeats.Utilities.Constants;
import com.google.gson.Gson;

public class RestoActivity extends AppCompatActivity {

    Context context;

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



        } else {
            Toast.makeText(context, "Erreur lors du chargement des informations de restaurant.", Toast.LENGTH_SHORT).show();
        }
    }
}
