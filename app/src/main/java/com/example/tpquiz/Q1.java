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
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class Q1 extends AppCompatActivity {

    Singleton queue;
    String shurt = "https://api.spotify.com/v1/tracks/6QdnKD1zwEgyOWtkrdzlOF"; // HURT YOU - MY DEAR MELANCHOLY
    String spmonster = "https://api.spotify.com/v1/tracks/4F7A0DXBrmUAkp32uenhZt"; // Party Monster - Starboy
    String swander = "https://api.spotify.com/v1/tracks/6V9TlCdwLeQes4FX5zxz3f"; // Wanderlust - Kissland
    String smoth = "https://api.spotify.com/v1/tracks/0VO8gYVDSwM1Qdd2GsMoYK"; // Moth To A Flame - Paradise Again
    String smtl = "https://api.spotify.com/v1/tracks/0UGdO687azruy9tFlCxO6F"; // Montreal - Echoes of Silence

    JsonObjectRequest jq1, jhurt, jpmonster, jwander, jmoth, jmtl;
    Chronometer chronometer;
    Method method = new Method();
    JSON json = new JSON();
    TextView reponse, question;
    Button b1, b2, b3, b4;
//    Method method = new Method(reponse, json, chronometer, this);

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

        String qstruct = " apparait dans quel album de TheWeeknd?";
        String[] q1s = {"'Hurt You ft. Gesaffelstein'", "'Party Monster'", "'Wanderlust", "'Moth To A Flame'", "Montreal"};
        int rand = new Random().nextInt(q1s.length);

        b1.setText("Starboy");
        b2.setText("My Dear Melancholy,");
        b3.setText("Thursday");
        b4.setText("Aucun album, c'est un single");

        question.setText(q1s[rand] + qstruct);
        queue = Singleton.getInstance(this);

        if (rand == 0) {
            jhurt = json.jsoning(jq1, shurt, null, this);
            queue.addToRequestQueue(jhurt);
            onClick(b2);
        } else if (rand == 1) {
            b1.setText("Starboy");
            b2.setText("Kissland");
            b4.setText("Dawn FM");
            jpmonster = json.jsoning(jq1, spmonster, null, this);
            queue.addToRequestQueue(jpmonster);
            onClick(b1);
        } else if (rand == 2) {
            b1.setText("After Hours");
            b2.setText("Kissland");
            b3.setText("Donda");
            jwander = json.jsoning(jq1, swander, null, this);
            queue.addToRequestQueue(jwander);
            onClick(b2);
        } else if (rand == 3) {
            b1.setText("Paradise Again");
            b2.setText("Positions");
            jmoth = json.jsoning(jq1, smoth, null, this);
            queue.addToRequestQueue(jmoth);
            onClick(b1);
        } else if (rand == 4) {
            b1.setText("House of Balloons");
            b2.setText("Aucun album, c'est un single");
            b4.setText("Echoes of Silence");
            jmtl = json.jsoning(jq1, smtl, null, this);
            queue.addToRequestQueue(jmtl);
            onClick(b4);
        }
    }

    @SuppressLint("SetTextI18n")
    public void onClick(Button b) {
        b.setOnClickListener(e -> {
            reponse.setText("c'est effectivement " + json.getTemp() + " !");
            chronometer.start();
            method.isPressed(chronometer, this);
        });
    }
}