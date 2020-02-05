package com.epicteck.ajayimajebijoshua.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.epicteck.ajayimajebijoshua.R;
import com.epicteck.ajayimajebijoshua.adapters.FilterAdapter;
import com.epicteck.ajayimajebijoshua.interfaces.FilterAPI;
import com.epicteck.ajayimajebijoshua.models.Filter;
import com.epicteck.ajayimajebijoshua.utils.HandleLoading;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.recycler)
    RecyclerView recycler_view;

    private FilterAdapter filterAdapter;

    private List<Filter> filters_list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recycler_view.setLayoutManager(linearLayoutManager);

        recycler_view.setLayoutManager(linearLayoutManager);


        recycler_view.setAdapter(ordersAdapter);

        HandleLoading.showLoading(this.getSupportFragmentManager());

        getFilters();
    }

    private void getFilters(){
        OkHttpClient.Builder client = new OkHttpClient.Builder();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        client.addInterceptor(loggingInterceptor);

        client.connectTimeout(15, TimeUnit.SECONDS);
        client.readTimeout(15, TimeUnit.SECONDS);

        Retrofit retrofit = new Retrofit.Builder()
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FilterAPI filterAPI = retrofit.create(FilterAPI.class);

        Call<List<Filter>> loginResponseCall = filterAPI.getFilters();

        loginResponseCall.enqueue(new Callback<List<Filter>>() {
            @Override
            public void onResponse(Call<List<Filter>> call, Response<List<Filter>> response) {
                HandleLoading.hideLoading();

                int statusCode = response.code();
                //we should get the saved id back
                switch(statusCode){
                    case 403:
                        break;
                    case 200:

                    case 400:
                        break;
                    case 404:
                        break;
                }
            }
            @Override
            public void onFailure(Call<List<Filter>> call, Throwable t) {
                HandleLoading.hideLoading();
            }
        });
    }

}
