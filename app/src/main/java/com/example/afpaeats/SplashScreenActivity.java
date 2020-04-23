package com.example.afpaeats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.afpaeats.Entities.Session;
import com.example.afpaeats.Utilities.Functions;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }

    private class SleepTask extends AsyncTask<String,String,String>
    {
        @Override
        protected String doInBackground(String... voids) {

            //Simule un appel service web
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //appel service web
            return Functions.callServiceWeb(null,"getid");
        }

        @Override
        protected void onPostExecute(String sessionId) {
            super.onPostExecute(sessionId);

            //Sauvegarde de l'idSession
            Session.setId(sessionId);

            //je bascule sur une activite
            Intent intent = new Intent(getApplicationContext(),PermissionsActivity.class);
            //in passe l'idsession
            intent.putExtra("sessionId",sessionId);
            startActivity(intent);

            finish();
        }
    }
}
