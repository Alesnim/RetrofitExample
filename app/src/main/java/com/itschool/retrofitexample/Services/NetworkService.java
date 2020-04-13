package com.itschool.retrofitexample.Services;


import android.util.Log;

import com.itschool.retrofitexample.Controllers.ShibeAPI;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class NetworkService {
    private static NetworkService mInstance;
    private Retrofit retroService;

    public NetworkService() {
        Log.d("TEG", "Create Network Service");
        retroService = new Retrofit
                .Builder()
                .baseUrl("http://shibe.online/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public Retrofit getRetroService() {
        return retroService;
    }

    public ShibeAPI createShubyAPI(){
        ShibeAPI shibeAPI = retroService.create(ShibeAPI.class);
        return shibeAPI;
    }


    public static NetworkService getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkService();
        }
        return mInstance;
    }


}
