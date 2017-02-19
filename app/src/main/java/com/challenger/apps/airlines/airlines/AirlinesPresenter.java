package com.challenger.apps.airlines.airlines;

import android.content.Context;

import com.challenger.apps.airlines.Data.DataCallback;
import com.challenger.apps.airlines.Data.DataFetcher;

import java.util.ArrayList;

/**
 * Created by Challenger on 2/19/17.
 */

public class AirlinesPresenter implements AirlinesContract.Presenter {

    private AirlinesContract.View view;
    private Context context;
    private DataFetcher dataFetcher;

    AirlinesPresenter(Context context, AirlinesContract.View view){
        this.context = context;
        this.view = view;
        dataFetcher = new DataFetcher(context);
    }

    @Override
    public void getAirlines() {
        dataFetcher.fetchAirlinesData(new DataCallback() {
            @Override
            public void onStartRequest() {
                view.showMessage("Loading...");
            }

            @Override
            public void onResultReceived(ArrayList arrayList) {
                view.onAirlinesDataReceived(arrayList);
            }

            @Override
            public void onError(String error) {
                view.showMessage("Error: " + error);
            }
        });
    }
}
