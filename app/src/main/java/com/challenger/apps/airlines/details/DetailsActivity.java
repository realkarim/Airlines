package com.challenger.apps.airlines.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.challenger.apps.airlines.R;

/**
 * Created by Challenger on 2/19/17.
 */

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new DetailsFragment())
                .commit();
    }
}
