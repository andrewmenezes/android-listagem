package com.fucapi.submarino.listagem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by berredo on 2/19/17.
 */

public class App {
    private static Retrofit initRetrofit(String url) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static APIService ApiInstance(String url) {
        return initRetrofit(url).create(APIService.class);
    }
}
