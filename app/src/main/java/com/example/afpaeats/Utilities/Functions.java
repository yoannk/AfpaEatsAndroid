package com.example.afpaeats.Utilities;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Functions {

    public static void getToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static String callServiceWeb(@Nullable HashMap<String,String> parameters, String methode)
    {
        String url= Constants.URL_SW + methode;
        //On instancie notre objet Okhttp
        OkHttpClient client = new OkHttpClient();
        String retourServiceWeb="";
        Request request;

        //on créée la demande à partir de l'url
        if(parameters == null || parameters.size() == 0)
        {
            request = new Request.Builder().url(url).build();
        }
        else
        {
            HttpUrl.Builder httpBuider = HttpUrl.parse(url).newBuilder();

            //on parcours tous les elements à envoyer
            for (Map.Entry<String, String> entry : parameters.entrySet()) {
                String key = entry.getKey();
                String val = entry.getValue();
                httpBuider.addQueryParameter(key, val);
            }

            request = new Request.Builder().url(httpBuider.build()).build();
        }

        try {
            //on obtient la réponse
            Response response = client.newCall(request).execute();

            if (response.isSuccessful())
            {
                //on recupère au format Json
                retourServiceWeb = response.body().string();
            }
        }
        catch (Exception ex)
        {
            retourServiceWeb = ex.getMessage();
        }
        return retourServiceWeb;
    }
}
