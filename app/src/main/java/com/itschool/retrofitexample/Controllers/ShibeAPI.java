package com.itschool.retrofitexample.Controllers;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ShibeAPI {

    @GET("shibes/")
    Call<List<String>> getUrlShibes();



    @GET
    Call<ResponseBody> getImageShibu(@Url String url);
}
