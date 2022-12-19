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
import java.util.Random;
import java.util.Vector;

public class Q2 extends AppCompatActivity {

    Method method = new Method();
    JSON json = new JSON();
    Singleton queue;
    String qt = "https://api.spotify.com/v1/albums/5EbpxRwbbpCJUepbqVTZ1U"; // Trilogy
    String qk = "https://api.spotify.com/v1/albums/3hhDpPtCFuQbppwYgsVhMO"; // Kissland
    String qb = "https://api.spotify.com/v1/albums/0P3oVJBFOv3TDXlYRhGL7s"; // Beauty Behind the Madness
    String qs = "https://api.spotify.com/v1/albums/2ODvWsOgouMbaA5xf0RkJe"; // STARBOY
    String qm = "https://api.spotify.com/v1/albums/4qZBW3f2Q8y0k1A84d4iAO"; // My Dear Melancholy,
    String qa = "https://api.spotify.com/v1/albums/4yP0hdKOZPNshxUOjY0cZj"; // After Hours
    String qd = "https://api.spotify.com/v1/albums/2nLOHgzXzwFEpl62zAgCEC"; // Dawn FM
    JsonObjectRequest jq2, jt, jk, jb, js, jm, ja, jd;

    NetworkImageView niw;

    Chronometer chronometer;
    TextView reponse, question;
    Button b1, b2, b3, b4;

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

        String s = "L'album ";
        String[] q2s = {"Trilogy", "Kissland", "Beauty Behind the Madness", "Starboy", "My Dear Melancholy,", "After Hours", "Dawn FM"};
        String qstruct = " est sortie en quel année?";
        int rand = new Random().nextInt(q2s.length);

        question.setText(s + q2s[rand] + qstruct);
        b1.setText("20XX");
        b2.setText("20XX");
        b3.setText("20XX");
        b4.setText("20XX");

        queue = Singleton.getInstance(this);

        method.animation(niw);

        if (rand == 0) {
            b1.setText("2010");
            b2.setText("2018");
            b3.setText("2015");
            b4.setText("2012");
            jt = json.jsoning(jq2, qt, niw, this);
            queue.addToRequestQueue(jt);
            method.onClick(b4, reponse, chronometer, this, json);
            reponse.setText("c'est effectivement en " + json.getTemp() + " !");
        } else if (rand == 1) {
            b1.setText("2022");
            b2.setText("2012");
            b3.setText("2013");
            b4.setText("2018");
            jk = json.jsoning(jq2, qk, niw, this);
            queue.addToRequestQueue(jk);
            method.onClick(b3, reponse, chronometer, this, json);
            reponse.setText("c'est effectivement en " + json.getTemp() + " !");
        } else if (rand == 2) {
            b1.setText("2015");
            b2.setText("2022");
            b3.setText("2014");
            b4.setText("2016");
            jb = json.jsoning(jq2, qb, niw, this);
            queue.addToRequestQueue(jb);
            method.onClick(b1, reponse, chronometer, this, json);
            reponse.setText("c'est effectivement en " + json.getTemp() + " !");
        } else if (rand == 3) {
            b1.setText("2009");
            b2.setText("2021");
            b3.setText("2016");
            b4.setText("2013");
            js = json.jsoning(jq2, qs, niw, this);
            queue.addToRequestQueue(js);
            method.onClick(b3, reponse, chronometer, this, json);
            reponse.setText("c'est effectivement en " + json.getTemp() + " !");
        } else if (rand == 4) {
            b1.setText("2012");
            b2.setText("2017");
            b3.setText("2019");
            b4.setText("2018");
            jm = json.jsoning(jq2, qm, niw, this);
            queue.addToRequestQueue(jm);
            method.onClick(b4, reponse, chronometer, this, json);
            reponse.setText("c'est effectivement en " + json.getTemp() + " !");
        } else if (rand == 5) {
            b1.setText("2021");
            b2.setText("2020");
            b3.setText("2018");
            b4.setText("2019");
            ja = json.jsoning(jq2, qa, niw, this);
            queue.addToRequestQueue(ja);
            method.onClick(b2, reponse, chronometer, this, json);
            reponse.setText("c'est effectivement en " + json.getTemp() + " !");
        } else if (rand == 6) {
            b1.setText("2021");
            b2.setText("2023");
            b3.setText("2022");
            b4.setText("2020");
            jd = json.jsoning(jq2, qd, niw, this);
            queue.addToRequestQueue(jd);
            method.onClick(b3, reponse, chronometer, this, json);
            reponse.setText("c'est effectivement en " + json.getTemp() + " !");
        }

        if (json.getTemp() == null){
            reponse.setText("");
        }
    }
}