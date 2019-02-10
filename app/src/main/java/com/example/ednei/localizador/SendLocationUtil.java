package com.example.ednei.localizador;

import android.os.AsyncTask;
import android.util.Log;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class SendLocationUtil extends AsyncTask<String, String, String> {

    private List lista;
    private String TAG ="SendLocationUtilLog";

    @Override
    protected String doInBackground(String... params) {


        String NewsData = "";

        try {

            HttpClient httpCliente = new DefaultHttpClient();
            HttpResponse httpResponse = httpCliente.execute(new HttpGet(params[0]));
            InputStream in = httpResponse.getEntity().getContent();
            NewsData = Stream2String(in);

            publishProgress(NewsData);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String Stream2String(InputStream in) {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line = "";
        String text = "";

        try {
            while((line=br.readLine())!=null) {
                text+=line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
