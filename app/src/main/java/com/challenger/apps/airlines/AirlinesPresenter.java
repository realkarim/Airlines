package com.challenger.apps.airlines;

import java.util.ArrayList;

/**
 * Created by Challenger on 2/19/17.
 */

public class AirlinesPresenter implements AirlinesContract.Presenter {

    AirlinesContract.View view;

    AirlinesPresenter(AirlinesContract.View view){
        this.view = view;
    }

    @Override
    public void getAirlines() {
        view.onAirlinesDataReceived(new ArrayList());
    }
}
