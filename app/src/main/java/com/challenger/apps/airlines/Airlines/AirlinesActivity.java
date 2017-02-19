package com.challenger.apps.airlines.Airlines;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.challenger.apps.airlines.R;

public class AirlinesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airlines);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new AirlinesFragment())
                .commit();
    }
}
