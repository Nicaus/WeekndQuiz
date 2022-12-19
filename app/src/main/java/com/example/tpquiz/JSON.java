package com.example.tpquiz;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

class JSON {
    private String temp;
    private String imageurl;

    public JsonObjectRequest jsoning(JsonObjectRequest json, String url, NetworkImageView niw, Context ctx) {
        json = new JsonObjectRequest(Request.Method.GET, url, null, response -> {
            try {
                if (ctx instanceof Q1){
                    JSONObject array = response.getJSONObject("album");
                    JSONArray image = array.getJSONArray("images");
                    JSONObject imageo = image.getJSONObject(0);
                    String imageurl = imageo.getString("url");
                    setImageurl(imageurl);
                    temp = array.getString("name");
                } else if (ctx instanceof Q2){
                    temp = response.getString("release_date");
                } else if (ctx instanceof Q3){
                    temp = response.getString("popularity");
                    temp = response.getString("name");
                }
                setTemp(temp);
                if (niw != null) {
                    JSONArray image = response.getJSONArray("images");
                    JSONObject imageo = image.getJSONObject(0);
                    String imageurl = imageo.getString("url");
                    niw.setImageUrl(imageurl, Singleton.getInstance(ctx).getImageLoader());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, null) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                String token = Singleton.getInstance(ctx.getApplicationContext()).getSharedPreferences().getString("token", "");
                String auth = "Bearer " + token;
                headers.put("Authorization", auth);
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };
        return json;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
