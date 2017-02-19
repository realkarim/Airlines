package com.challenger.apps.airlines.Airlines;

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

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Challenger on 2/19/17.
 */


public class AirlinesFragment extends Fragment implements AirlinesContract.View {

    @BindView(R.id.airlines_recycler_view)
    RecyclerView airlinesRecyclerView;

    private AirlinesPresenter airlinesPresenter;
    private AirlinesContract.Presenter airlinesPresenterInterface;

    private RecyclerView.LayoutManager mLayoutManager;
    private AirlinesRecyclerViewAdapter airlinesRecyclerViewAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_airlines, container, false);
        ButterKnife.bind(this, view);

        airlinesPresenter = new AirlinesPresenter(getActivity(), this);
        airlinesPresenterInterface = airlinesPresenter;

        // setup RecyclerView
        mLayoutManager = new LinearLayoutManager(getActivity());
        airlinesRecyclerView.setLayoutManager(mLayoutManager);
        airlinesRecyclerViewAdapter = new AirlinesRecyclerViewAdapter(getActivity());
        airlinesRecyclerView.setAdapter(airlinesRecyclerViewAdapter);

        // load data
        airlinesPresenterInterface.getAirlines();

        return  view;
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
