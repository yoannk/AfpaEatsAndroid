package com.example.afpaeats.Utilities;

import android.app.Application;

import com.example.afpaeats.Entities.Restaurants;
import com.example.afpaeats.Entities.TypeCuisines;

public class App extends Application {
    private static Restaurants restaurants;
    private static TypeCuisines typeCuisines;

    public static Restaurants getRestaurants() {
        return restaurants;
    }

    public static void setRestaurants(Restaurants restaurants) {
        if (restaurants == null) {
            restaurants = new Restaurants();
        }
        App.restaurants = restaurants;
    }

    public static TypeCuisines getTypeCuisines() {
        return typeCuisines;
    }

    public static void setTypeCuisines(TypeCuisines typeCuisines) {
        App.typeCuisines = typeCuisines;
    }
}
