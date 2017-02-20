package com.challenger.apps.airlines.data;

import java.util.ArrayList;

/**
 * Created by Challenger on 2/20/17.
 */

public interface StorageInterface {
    boolean save(AirlineModel airlineModel);

    boolean delete(String code);

    boolean isSaved(String code);

    ArrayList getFavorites();
}
