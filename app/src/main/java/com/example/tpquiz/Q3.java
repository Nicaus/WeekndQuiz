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
    JsonObjectRequest jsonq3a, jsonq3b, jsonr1, jsonr2;
    JSON json = new JSON();
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
            reponse.setText("OUI, c'est effectivement " + json.getTemp() + " !");
            chronometer.start();
            method.isPressed(chronometer, this);

        });

        queue = Singleton.getInstance(this);

        jsonr1 = json.jsoning(jsonq3a, q3a, niw1, this);
        jsonr2 = json.jsoning(jsonq3b, q3b, niw2, this);

        queue.addToRequestQueue(jsonr1);
        queue.addToRequestQueue(jsonr2);
    }
}