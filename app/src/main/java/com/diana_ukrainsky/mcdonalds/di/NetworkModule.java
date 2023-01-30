package com.diana_ukrainsky.mcdonalds.di;

import com.diana_ukrainsky.mcdonalds.common.Constants;
import com.diana_ukrainsky.mcdonalds.data.remote.JsonApiMenuItem;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule {
    @Provides
    @Singleton
    public static JsonApiMenuItem provideRecipeApiService(){

        return  new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(JsonApiMenuItem.class);
    }
}
