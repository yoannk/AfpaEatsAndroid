package com.example.afpaeats.Utilities;

import android.os.AsyncTask;

import java.util.HashMap;

public class ServiceWebTask extends AsyncTask<String, String, String> {

    int _idSw;
    String _methodeSw;
    HashMap<String, String> _parameters;
    InterfaceServiceWeb _interfaceServiceWeb;

    public interface InterfaceServiceWeb {
        void returnSw(String value,int idSw);
    }

    public ServiceWebTask(String methodeSw, HashMap<String, String> parameters, int idSw, InterfaceServiceWeb interfaceServiceWeb) {
        this._methodeSw = methodeSw;
        this._parameters = parameters;
        this._idSw = idSw;
        this._interfaceServiceWeb = interfaceServiceWeb;
    }

    @Override
    protected String doInBackground(String... voids) {

        //Simule un appel service web
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //appel service web
        return Functions.callServiceWeb(_parameters, _methodeSw, _idSw);
    }

    @Override
    protected void onPostExecute(String returnSw) {
        super.onPostExecute(returnSw);

        _interfaceServiceWeb.returnSw(returnSw, this._idSw);

    }
}
