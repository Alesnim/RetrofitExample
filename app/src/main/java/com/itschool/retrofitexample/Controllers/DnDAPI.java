package com.itschool.retrofitexample.Controllers;

import com.itschool.retrofitexample.Spells;

import java.util.List;

import retrofit2.Response;
import retrofit2.http.GET;

public interface DnDAPI {

    @GET("spells/")
    Response<List<Spells>> getSpells();
}
