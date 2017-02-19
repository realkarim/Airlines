package com.challenger.apps.airlines.Data;

import java.util.ArrayList;

/**
 * Created by Challenger on 2/19/17.
 */

public interface DataCallback {
    void onStartRequest();

    void onResultReceived(ArrayList arrayList);

    void onError(String error);
}
