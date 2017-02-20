package com.challenger.apps.airlines.dagger;

import android.app.Application;
import android.os.Handler;

import com.challenger.apps.airlines.dagger.mocks.MockDataFetcher;
import com.challenger.apps.airlines.dagger.mocks.MockStorageDB;
import com.challenger.apps.airlines.data.AirlinesParser;
import com.challenger.apps.airlines.data.DataFetcher;
import com.challenger.apps.airlines.data.StorageDB;

import dagger.Module;
import okhttp3.OkHttpClient;

/**
 * Created by Challenger on 2/20/17.
 */

public class MockAppModule extends AppModule {
    public MockAppModule(Application application) {
        super(application);
    }

    @Override
    protected DataFetcher providesDataFetcher(Application context, OkHttpClient okHttpClient, Handler
            mainHandler, AirlinesParser airlinesParser) {
        return new MockDataFetcher(null, null, null, null);
    }

    @Override
    protected StorageDB providesStorageDB(Application context) {
        return new MockStorageDB(null);
    }
}

