package com.challenger.apps.airlines.dagger.mocks;

import android.app.Application;
import android.os.Handler;

import com.challenger.apps.airlines.data.AirlineModel;
import com.challenger.apps.airlines.data.AirlinesParser;
import com.challenger.apps.airlines.data.DataCallback;
import com.challenger.apps.airlines.data.DataFetcher;

import java.util.ArrayList;

import okhttp3.OkHttpClient;

/**
 * Created by Challenger on 2/20/17.
 */

public class MockDataFetcher extends DataFetcher {
    public MockDataFetcher(Application context, OkHttpClient okHttpClient, Handler mainHandler, AirlinesParser airlinesParser) {
        super(context, okHttpClient, mainHandler, airlinesParser);
    }

    public void fetchAirlinesData(final DataCallback dataCallback){

        ArrayList<AirlineModel> airlineModels = new ArrayList<>();
        AirlineModel airlineModel0 = new AirlineModel();
        airlineModel0.setCode("0");
        airlineModel0.setUsName("0");
        airlineModel0.setSite("0");
        airlineModel0.setPhone("0");
        AirlineModel airlineModel1 = new AirlineModel();
        airlineModel0.setCode("1");
        airlineModel0.setUsName("1");
        airlineModel0.setSite("1");
        airlineModel0.setPhone("1");

        airlineModels.add(airlineModel0);
        airlineModels.add(airlineModel1);

        dataCallback.onResultReceived(airlineModels);
    }

}
