package com.challenger.apps.airlines.airlines;

import android.content.Context;

import com.challenger.apps.airlines.data.DataCallback;
import com.challenger.apps.airlines.data.DataFetcher;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by Challenger on 2/19/17.
 */

public class AirlinesPresenter implements AirlinesContract.Presenter {

    private AirlinesContract.View view;

    @Inject
    DataFetcher dataFetcher;

    @Inject
    AirlinesPresenter(){
    }

    @Override
    public void setView(AirlinesContract.View view){
        this.view = view;
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
