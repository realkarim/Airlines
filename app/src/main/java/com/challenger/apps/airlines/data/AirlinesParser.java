package com.challenger.apps.airlines.data;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by Challenger on 2/19/17.
 */

public class AirlinesParser {

    public static AirlineModel parseAirlineObject(String object){
        Gson gson = new Gson();
        AirlineModel airlineModel = gson.fromJson(object, AirlineModel.class);
        return airlineModel;
    }

    public static ArrayList<AirlineModel> parseAirlineArray(String array){
        ArrayList<AirlineModel> airlineModelArrayList = null;
        try {
            JSONArray jsonArray = new JSONArray(array);
            airlineModelArrayList = new ArrayList<>();

            for(int i=0;i<jsonArray.length();i++)
                airlineModelArrayList.add(parseAirlineObject(jsonArray.get(i).toString()));

        } catch (JSONException e) {
            Log.e("AirlinesParser", e.getMessage());
        }
        return airlineModelArrayList;
    }
}
