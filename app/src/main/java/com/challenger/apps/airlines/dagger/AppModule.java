package com.challenger.apps.airlines.dagger;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

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
}
