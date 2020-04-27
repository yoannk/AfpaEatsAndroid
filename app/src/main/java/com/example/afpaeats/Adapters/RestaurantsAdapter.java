package com.example.afpaeats.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.afpaeats.Entities.Restaurant;
import com.example.afpaeats.Entities.Restaurants;
import com.example.afpaeats.R;
import com.example.afpaeats.RestoActivity;
import com.example.afpaeats.Utilities.Constants;
import com.google.gson.Gson;

public class RestaurantsAdapter extends RecyclerView.Adapter<RestaurantHolder> {

    Restaurants _restaurants;
    Context _context;

    public RestaurantsAdapter(Restaurants restaurants, Context context) {

        this._restaurants = restaurants;
        this._context = context;
    }

    @NonNull
    @Override
    public RestaurantHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //on récupére le fichier xml graphique parmi les layouts
        View view = LayoutInflater.from(_context).inflate(R.layout.item_type_cuisne,parent,false);
        //on passe notre objet(view) à notre view holder
        return new RestaurantHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantHolder restaurantHolder, int position) {
        //on recupére un adherent parmi la liste des adherents en fonction de sa position
        final Restaurant restaurant = this._restaurants.get(position);
        //on passe l'objet adherent a notre viewholder
        restaurantHolder.setRestaurant(restaurant);

        restaurantHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(_context, "hello " + restaurant.getNom(), Toast.LENGTH_SHORT).show();

                Gson gson = new Gson();
                String restaurantJson = gson.toJson(restaurant);

                Intent intent = new Intent(_context, RestoActivity.class);
                intent.putExtra(Constants.RESTAURANT_JSON, restaurantJson);

                _context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return _restaurants.size();
    }
}

class RestaurantHolder extends RecyclerView.ViewHolder {

    public final TextView txtNom;

    public RestaurantHolder(@NonNull View view) {
        super(view);

        //on initialise les widgets qui sont dans le layout
        txtNom = view.findViewById(R.id.txtNom);
    }

    public void setRestaurant(Restaurant restaurant)
    {
        // le match des donneés avec les widgets
        txtNom.setText(restaurant.getNom());
    }
}