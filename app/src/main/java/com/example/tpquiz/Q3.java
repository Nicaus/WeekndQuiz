package com.example.tpquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

public class Q3 extends AppCompatActivity {

    Singleton queue;
    String q3a = "https://api.spotify.com/v1/albums/2nLOHgzXzwFEpl62zAgCEC"; // DAWN FM
    String q3b = "https://api.spotify.com/v1/albums/4yP0hdKOZPNshxUOjY0cZj"; // AFTER HOURS
    JsonObjectRequest jsonq3a, jsonq3b;
    SharedPreferences sharedPreferences;
    NetworkImageView niw1, niw2;
    Chronometer chronometer;
    Method method = new Method();

    TextView reponse, question;
    Button b1, b2;

    String tempa, tempb;
    boolean r = false;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q3);
        reponse = findViewById(R.id.q3reponse);
        niw1 = findViewById(R.id.image1);
        niw2 = findViewById(R.id.image2);
        question = findViewById(R.id.q3question);
        chronometer = findViewById(R.id.chrono3);

        b1 = findViewById(R.id.r1);
        b2 = findViewById(R.id.r2);

        question.setText("Quel album est plus populaire");
        b1.setText("Dawn FM");
        b2.setText("After Hours");

        b1.setOnClickListener(e -> r = false);
        b2.setOnClickListener(e -> {
            r = true;
            reponse.setText("OUI, c'est effectivement " + tempb + " !");
            chronometer.start();
            method.isPressed(chronometer, this);

        });

        sharedPreferences = getApplicationContext().getSharedPreferences("SPOTIFY", 0);
        queue = Singleton.getInstance(this);

        jsonq3a = new JsonObjectRequest(Request.Method.GET, q3a, null, response -> {
            try {
                tempa = response.getString("popularity");
                JSONArray image = response.getJSONArray("images");
                JSONObject imageo = image.getJSONObject(0);
                String imageurl = imageo.getString("url");
                niw1.setImageUrl(imageurl, Singleton.getInstance(this.getApplicationContext()).getImageLoader());
                tempa = response.getString("name");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, null){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                String token = sharedPreferences.getString("token", "");
                String auth = "Bearer " + token;
                headers.put("Authorization", auth);
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };
        jsonq3b = new JsonObjectRequest(Request.Method.GET, q3b, null, response -> {
            try {
                tempb = response.getString("popularity");
                JSONArray image = response.getJSONArray("images");
                JSONObject imageo = image.getJSONObject(0);
                String imageurl = imageo.getString("url");
                niw2.setImageUrl(imageurl, Singleton.getInstance(this.getApplicationContext()).getImageLoader());
                tempb = response.getString("name");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, null){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                String token = sharedPreferences.getString("token", "");
                String auth = "Bearer " + token;
                headers.put("Authorization", auth);
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };
        queue.addToRequestQueue(jsonq3a);
        queue.addToRequestQueue(jsonq3b);
    }
}