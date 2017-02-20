package com.challenger.apps.airlines.dagger.mocks;

import android.content.Context;

import com.challenger.apps.airlines.data.AirlineModel;
import com.challenger.apps.airlines.data.StorageDB;

import java.util.ArrayList;

/**
 * Created by Challenger on 2/20/17.
 */

public class MockStorageDB extends StorageDB {

    private ArrayList<AirlineModel> airlineModelArrayList = new ArrayList<>();

    public MockStorageDB(Context context) {
        super(context);
    }

    @Override
    public boolean save(AirlineModel airlineModel) {
        airlineModelArrayList.add(airlineModel);
        return true;
    }

    @Override
    public boolean delete(String code) {
        for(int i=0;i<airlineModelArrayList.size();i++)
            if(airlineModelArrayList.get(i).getCode().equals(code))
                airlineModelArrayList.remove(i);

        return true;
    }

    @Override
    public boolean isSaved(String code) {
        for(int i=0;i<airlineModelArrayList.size();i++)
            if(airlineModelArrayList.get(i).getCode().equals(code))
                return true;

        return false;
    }

    @Override
    public ArrayList<AirlineModel> getFavorites() {

        return airlineModelArrayList;
    }


}
