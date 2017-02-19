package com.fucapi.submarino.listagem;

/**
 * Created by berredo on 2/19/17.
 */

public class App {
    public static void initRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
