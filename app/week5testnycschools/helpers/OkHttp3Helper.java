package com.example.week5testnycschools.helpers;

import android.content.Context;
import android.util.Log;

import com.example.week5testnycschools.events.SatEvent;
import com.example.week5testnycschools.events.SchoolEvent;
import com.example.week5testnycschools.pojos.Sat.Sat;
import com.example.week5testnycschools.pojos.school.School;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttp3Helper {

    public static final String TAG = "FRANK: ";

    //API call for the school list
    public static void schoolAsyncOkHttpApiCall(String url, Context context) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            String jsonResponse;

            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: ", e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    //PARSE through Gson
                    jsonResponse = response.body().string();
                    Gson gson = new Gson();
                    School[] schools = gson.fromJson(jsonResponse, School[].class);
                    //SEND array through EventBas to MainActivity
                    EventBus.getDefault().post(new SchoolEvent(schools));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //API call for sat list
    public static void satAsyncOkHttpApiCall(String url, Context context) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            String jsonResponse;

            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: ", e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    //PARSE through Gson
                    jsonResponse = response.body().string();
                    Gson gson = new Gson();
                    Sat[] sats = gson.fromJson(jsonResponse, Sat[].class);
                    //SEND by EventBus to MainActivity
                    EventBus.getDefault().post(new SatEvent(sats));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
