package com.ubots.loja.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Factory {

    public static Retrofit getRetroFit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.mocky.io/v2/598b16861100004905515ec7/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
