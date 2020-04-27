package com.example.afpaeats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.afpaeats.Entities.Restaurants;
import com.example.afpaeats.Entities.Session;
import com.example.afpaeats.Utilities.ServiceWebTask;

public class SplashScreenActivity extends AppCompatActivity implements ServiceWebTask.InterfaceServiceWeb {

    boolean _isSw1 = false;
    boolean _isSw2 = false;
    boolean _isSw3 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ServiceWebTask serviceWebGetId = new ServiceWebTask("getId", null, 1, SplashScreenActivity.this);
        serviceWebGetId.execute();

        ServiceWebTask serviceWebGetRestaurants = new ServiceWebTask("getAssociations", null, 2, SplashScreenActivity.this);
        serviceWebGetRestaurants.execute();
    }

    @Override
    public void returnSw(String value, int idSw) {

        switch (idSw) {
            case 1:
                //Sauvegarde de l'idSession
                Session.setId(value);
                _isSw1 = true;
                break;
            case 2:
                _isSw2 = true;
                break;
            case 3:
                _isSw3 = true;
                break;
        }

        if (_isSw1 && _isSw2) {
            //je bascule sur une activite
            Intent intent = new Intent(getApplicationContext(),PermissionsActivity.class);
            intent.putExtra("tt", "");
            startActivity(intent);

            finish();
        }
    }
}
