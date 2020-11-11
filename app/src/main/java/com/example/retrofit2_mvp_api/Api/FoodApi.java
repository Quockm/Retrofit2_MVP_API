package com.example.retrofit2_mvp_api.Api;

import com.example.retrofit2_mvp_api.model.Categories;
import com.example.retrofit2_mvp_api.model.Meals;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by QuocKM on 11,November,2020
 * EbizWorld company,
 * HCMCity, VietNam.
 */
public interface FoodApi {
    @GET("latest.php")
    Call<Meals> getMeal();

    @GET("categories.php")
    Call<Categories> getCategories();

    @GET("filter.php")
    Call<Meals> getMealByCategory(@Query("c") String category);
}
