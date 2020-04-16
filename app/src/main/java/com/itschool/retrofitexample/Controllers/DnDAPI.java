package com.itschool.retrofitexample.Controllers;

import com.itschool.retrofitexample.models.Spells;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface DnDAPI {

    @GET("spells/")
    Call<Spells> getSpells();
}
