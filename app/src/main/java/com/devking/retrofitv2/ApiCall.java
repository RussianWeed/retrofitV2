package com.devking.retrofitv2;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCall {

    @GET("comments")
    Call<ArrayList<retrofit_model>> get_model();

}
