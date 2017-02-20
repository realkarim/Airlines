package com.challenger.apps.airlines.details;

import com.challenger.apps.airlines.airlines.AirlinesContract;
import com.challenger.apps.airlines.data.AirlineModel;

import java.util.ArrayList;

/**
 * Created by Challenger on 2/19/17.
 */

public interface DetailsContract {
    interface View{

        void showMessage(String message);
    }

    interface Presenter{

        void setView(View view);

        void save(AirlineModel airlineModel);

        boolean isSaved(String code);

        void delete(String code);
    }
}
