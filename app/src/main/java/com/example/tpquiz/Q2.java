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

public class Q2 extends AppCompatActivity {

    Method method = new Method();
    JSON json = new JSON();
    Singleton queue;
    String q2 = "https://api.spotify.com/v1/albums/2ODvWsOgouMbaA5xf0RkJe"; // STARBOY
    JsonObjectRequest jsonq2, jsonreturned;
    SharedPreferences sharedPreferences;
    NetworkImageView niw;

    Chronometer chronometer;
    TextView reponse, question;
    Button b1, b2, b3, b4;
    String temp;
    boolean r = false;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q2);
        reponse = findViewById(R.id.q2reponse);
        niw = findViewById(R.id.q2image);
        question = findViewById(R.id.q2question);
        b1 = findViewById(R.id.q2b1);
        b2 = findViewById(R.id.q2b2);
        b3 = findViewById(R.id.q2b3);
        b4 = findViewById(R.id.q2b4);
        chronometer = findViewById(R.id.chrono2);

        question.setText("L'album 'Starboy' est sortie en quel année?");
        b1.setText("2015");
        b2.setText("2017");
        b3.setText("2014");
        b4.setText("2016");

        b1.setOnClickListener(e -> r = false);
        b2.setOnClickListener(e -> r = false);
        b3.setOnClickListener(e -> r = false);
        b4.setOnClickListener(e -> {
            r = true;
            reponse.setText("OUI, c'est effectivement " + json.getTemp() + " !");
            chronometer.start();
            method.isPressed(chronometer, this);
        });

        queue = Singleton.getInstance(this);

        jsonreturned = json.jsoning(jsonq2, q2, niw, this);
        temp = json.getTemp();

        queue.addToRequestQueue(jsonreturned);
    }
}