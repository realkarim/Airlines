package com.challenger.apps.airlines.airlines;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.challenger.apps.airlines.R;
import com.challenger.apps.airlines.dagger.MyApplication;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Challenger on 2/19/17.
 */


public class AirlinesFragment extends Fragment implements AirlinesContract.View {

    @BindView(R.id.airlines_recycler_view)
    RecyclerView airlinesRecyclerView;

    @Inject
    AirlinesPresenter airlinesPresenter;
    private AirlinesContract.Presenter airlinesPresenterInterface;

    private RecyclerView.LayoutManager mLayoutManager;
    @Inject
    AirlinesRecyclerViewAdapter airlinesRecyclerViewAdapter;

    private boolean showingFavorites = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_airlines, container, false);

        ((MyApplication) getActivity().getApplication()).getBaseComponent().inject(this);
        ButterKnife.bind(this, view);

        airlinesPresenter.setView(this);
        airlinesPresenterInterface = airlinesPresenter;

        // setup RecyclerView
        mLayoutManager = new LinearLayoutManager(getActivity());
        airlinesRecyclerView.setLayoutManager(mLayoutManager);
        airlinesRecyclerView.setAdapter(airlinesRecyclerViewAdapter);

        // load data
        airlinesPresenterInterface.getAirlines();

        return  view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(showingFavorites)
            airlinesPresenterInterface.getFavorites();
    }

    @OnClick({R.id.all, R.id.favorites})
    public void radio(View view) {
        switch (view.getId()){
            case R.id.all:
                airlinesPresenterInterface.getAirlines();
                showingFavorites =false;
                break;

            case R.id.favorites:
                airlinesPresenterInterface.getFavorites();
                showingFavorites = true;
                break;
        }
    }

    @Override
    public void onAirlinesDataReceived(ArrayList airlinesList) {
        airlinesRecyclerViewAdapter.updateAirlinesList(airlinesList);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
