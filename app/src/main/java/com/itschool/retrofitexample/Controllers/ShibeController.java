package com.itschool.retrofitexample.Controllers;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.itschool.retrofitexample.MainActivity;
import com.itschool.retrofitexample.Services.NetworkService;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ShibeController implements Callback<List<String>> {
    private NetworkService service;
    private ArrayList<String> shibes;
    private Handler handler;
    MainActivity mainActivity;

    public ShibeController() {
        service = NetworkService.getInstance();
        ShibeAPI shibeAPI = service.createShubyAPI();
        Call<List<String>> call = shibeAPI.getUrlShibes();
    }

    public ShibeController(MainActivity mainActivity) {
        service = NetworkService.getInstance();
        ShibeAPI shibeAPI = service.createShubyAPI();
        Call<List<String>> call = shibeAPI.getUrlShibes();
        this.mainActivity = mainActivity;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void onResponse(Call<List<String>> call, Response<List<String>> response) {
        if (response.isSuccessful()) {
           /* List<String> changesList = response.body();
            changesList.forEach(new Consumer<String>() {
                @Override
                public void accept(String change) {
                    Log.d("TAG", change);
                }
            });*/
            shibes = (ArrayList<String>) response.body();
            //Log.d("TAG", "eeee" + shibes);
            Message msg = Message.obtain();
            msg.obj = shibes.get(0);
            handler.sendMessage(msg);

            mainActivity.getResource(shibes.get(0));
            Log.d("TAG", String.valueOf(response.body().get(0)));
        } else {
            Log.d("TAG", "Error " + response.body());

        }

    }

    @Override
    public void onFailure(Call<List<String>> call, Throwable t) {
        t.printStackTrace();
    }


    public String shibeName() {
        return shibes.get(0);
    }

}
