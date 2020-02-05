package com.epicteck.ajayimajebijoshua.interfaces;

import com.epicteck.ajayimajebijoshua.models.Filter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FilterAPI {
    @GET("https://ven10.co/assessment/filter.json")
    Call<List<Filter>> getFilters();
}
