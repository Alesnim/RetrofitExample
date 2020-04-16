package com.itschool.retrofitexample.Services;

import android.util.Log;

import com.itschool.retrofitexample.Controllers.DnDAPI;
import com.itschool.retrofitexample.Controllers.ShibeAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkDNDService {
    private static NetworkDNDService mInstance;
    private Retrofit retroService;

    public NetworkDNDService() {
        Log.d("TEG", "Create Network Service");
        retroService = new Retrofit
                .Builder()
                .baseUrl("http://dnd5eapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public Retrofit getRetroService() {
        return retroService;
    }

    public DnDAPI createDNDAPI(){
        DnDAPI dndAPI = retroService.create(DnDAPI.class);
        return dndAPI;
    }


    public static NetworkDNDService getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkDNDService();
        }
        return mInstance;
    }


}
