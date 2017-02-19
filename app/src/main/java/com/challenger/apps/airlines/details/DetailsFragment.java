package com.challenger.apps.airlines.details;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.challenger.apps.airlines.R;
import com.challenger.apps.airlines.dagger.MyApplication;
import com.challenger.apps.airlines.data.AirlineModel;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Challenger on 2/19/17.
 */

public class DetailsFragment extends Fragment {

    @BindView(R.id.airline_logo)
    ImageView airlineLogo;

    @BindView(R.id.airline_name)
    TextView airlineName;

    @BindView(R.id.airline_website)
    TextView airlineWebsite;

    @BindView(R.id.airline_phone)
    TextView airlinePhone;

    @Inject
    Application context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        ((MyApplication) getActivity().getApplication()).getBaseComponent().inject(this);

        ButterKnife.bind(this, view);

        AirlineModel airlineModel = getActivity().getIntent().getParcelableExtra("airline");

        // show logo
        String baseUrl = context.getString(R.string.airline_logo_base_url);
        Picasso.with(context)
                .load(baseUrl + airlineModel.getLogoURL())
                .error(R.drawable.photo_not_available)
                .placeholder(R.drawable.loading)
                .into(airlineLogo);

        // show details
        airlineName.setText(airlineModel.getName());
        airlineWebsite.setText(airlineModel.getSite());
        airlinePhone.setText(airlineModel.getPhone());

        return view;
    }

    @OnClick(R.id.go)
    public void goToWebsite(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + airlineWebsite.getText().toString()));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @OnClick(R.id.call)
    public void call(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + airlinePhone.getText().toString()));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
