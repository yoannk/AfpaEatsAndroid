package com.example.afpaeats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.afpaeats.Entities.Session;
import com.example.afpaeats.Utilities.ServiceWebTask;

public class SplashScreenActivity extends AppCompatActivity implements ServiceWebTask.InterfaceServiceWeb {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ServiceWebTask serviceWebTask = new ServiceWebTask("getId", null, 0, SplashScreenActivity.this);
        serviceWebTask.execute();
    }

    @Override
    public void returnSw(String value, int idSw) {
        //Sauvegarde de l'idSession
        Session.setId(value);

        //je bascule sur une activite
        Intent intent = new Intent(getApplicationContext(),PermissionsActivity.class);
        //in passe l'idsession
        intent.putExtra("sessionId",value);
        startActivity(intent);

        finish();
    }
}
