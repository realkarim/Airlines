package com.challenger.apps.airlines;

import java.util.ArrayList;

/**
 * Created by Challenger on 2/19/17.
 */

public interface AirlinesContract {

    interface View{
        void onAirlinesDataReceived(ArrayList airlinesList);

        void showMessage(String message);
    }

    interface Presenter{

        void getAirlines();
    }

}
