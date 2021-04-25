package com.smis935820.crud_retrofit.interfaces;

import com.smis935820.crud_retrofit.models.pet;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PetAPI {
    @GET("api/petfilter.php/")
    public Call<pet> find(@Query("id") String id);
}
