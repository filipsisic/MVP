package com.vasko.mvp.reftrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BASIC;

public class Rest {

    private static final String HTTPS = "https://api.github.com/";
    private static final Network mainClient;

    static {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BASIC);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit builder = new Retrofit.Builder()
                .baseUrl(HTTPS)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mainClient = builder.create(Network.class);
    }

    public static Network getClient() {
        return mainClient;
    }

}
