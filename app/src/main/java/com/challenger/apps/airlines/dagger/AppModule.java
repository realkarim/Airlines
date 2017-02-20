package com.challenger.apps.airlines.dagger;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import com.challenger.apps.airlines.airlines.AirlinesFragment;
import com.challenger.apps.airlines.data.AirlinesParser;
import com.challenger.apps.airlines.data.DataFetcher;
import com.challenger.apps.airlines.data.StorageDB;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by Challenger on 2/19/17.
 */
@Module
public class AppModule {

    Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }

    @Provides
    Gson providesGson() {
        return new Gson();
    }

    @Provides
    OkHttpClient providesOkHttpClient() {
        return new OkHttpClient();
    }

    @Provides
    Handler providesHandler() {
        return new Handler(Looper.getMainLooper());
    }

    @Provides
    AirlinesParser providesAirlinesParser(Gson gson) {
        return new AirlinesParser(gson);
    }

    @Provides
    DataFetcher providesDataFetcher(Application context, OkHttpClient okHttpClient, Handler mainHandler, AirlinesParser airlinesParser) {
        return new DataFetcher(context, okHttpClient, mainHandler, airlinesParser);
    }

    @Singleton
    @Provides
    StorageDB providesStorageDB(Application context){
        return new StorageDB(context);
    }

}