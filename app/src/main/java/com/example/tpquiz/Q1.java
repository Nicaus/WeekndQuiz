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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class Q1 extends AppCompatActivity {

    Singleton queue;
    String q1 = "https://api.spotify.com/v1/tracks/6QdnKD1zwEgyOWtkrdzlOF"; // HURT YOU - MY DEAR MELANCHOLY
    JsonObjectRequest jsonq1;
    SharedPreferences sharedPreferences;
    Chronometer chronometer;
    Method method = new Method();

    TextView reponse, question;
    Button b1, b2, b3, b4;
    String temp;
    boolean r = false;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1);
        reponse = findViewById(R.id.q1reponse);
        question = findViewById(R.id.q1text);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        chronometer = findViewById(R.id.chrono);

        question.setText("'Hurt You ft. Gesaffelstein' apparait dans quel album de TheWeeknd?");
        b1.setText("Starboy");
        b2.setText("My Dear Melancholy,");
        b3.setText("Echoes of Silence");
        b4.setText("Aucun album, c'est un single");

        b1.setOnClickListener(e -> r = false);
        b2.setOnClickListener(e -> {
            r = true;
            reponse.setText("OUI, c'est effectivement " + temp + " !");
//            intent = new Intent(Q1.this, Q2.class);
            chronometer.start();
//            isPressed(intent, chronometer);
            method.isPressed(chronometer, this);
        });
        b3.setOnClickListener(e -> r = false);
        b4.setOnClickListener(e -> r = false);

        sharedPreferences = getApplicationContext().getSharedPreferences("SPOTIFY", 0);
        queue = Singleton.getInstance(this);

        jsonq1 = new JsonObjectRequest(Request.Method.GET, q1, null, response -> {
            try {
                JSONObject array = response.getJSONObject("album");
                temp = array.getString("name");
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
        queue.addToRequestQueue(jsonq1);
    }
}