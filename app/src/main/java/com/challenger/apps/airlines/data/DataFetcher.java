package com.challenger.apps.airlines.data;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;

import com.challenger.apps.airlines.R;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Challenger on 2/19/17.
 */

public class DataFetcher {
    private Context context;
    private OkHttpClient okHttpClient;
    private Handler mainHandler;

    public DataFetcher(Context context){
        this.context = context;
        okHttpClient = new OkHttpClient();
        mainHandler = new Handler(Looper.getMainLooper());
    }

    public void fetchAirlinesData(final DataCallback dataCallback){

        // notify method caller that request is getting started
        dataCallback.onStartRequest();

        // create full url
        String baseURL = context.getString(R.string.airlines_url);
        Uri builtUri = Uri.parse(baseURL)
                .buildUpon()
                .build();

        final String finalURL = builtUri.toString();

        // create request
        Request request = new Request.Builder()
                .url(finalURL)
                .build();

        // send request
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                // forward error message to method caller
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        dataCallback.onError(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final ArrayList<AirlineModel> airlineModelArrayList = AirlinesParser.parseAirlineArray(response.body().string());
                if(airlineModelArrayList == null){
                    dataCallback.onError("Error parsing data!");
                    return;
                }
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        dataCallback.onResultReceived(airlineModelArrayList);
                    }
                });
            }
        });

    }


}
