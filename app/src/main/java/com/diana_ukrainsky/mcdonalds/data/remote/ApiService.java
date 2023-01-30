package com.diana_ukrainsky.mcdonalds.data.remote;

import com.diana_ukrainsky.mcdonalds.common.Constants;
import com.google.gson.Gson;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiService {

    private static ApiService INSTANCE = null;
    private JsonApiMenuItem jsonApiMenuItem;
    private ApiService() {
        initializeRetrofit();
    }

    public static ApiService getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ApiService();

        return INSTANCE;
    }

    private void initializeRetrofit() {
        jsonApiMenuItem =new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(JsonApiMenuItem.class);
    }

    public JsonApiMenuItem getJsonApiMenuItem() {
        return jsonApiMenuItem;
    }
}
