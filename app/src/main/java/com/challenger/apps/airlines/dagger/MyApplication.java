package com.challenger.apps.airlines.dagger;

import android.app.Application;

/**
 * Created by Challenger on 2/19/17.
 */

public class MyApplication extends Application {

    BaseComponent baseComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        baseComponent = DaggerBaseComponent.builder()
                .appModule(new AppModule(this))
                .build();

    }

    public BaseComponent getBaseComponent() {
        return baseComponent;
    }


}