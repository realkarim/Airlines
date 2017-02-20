package com.challenger.apps.airlines.details;

import com.challenger.apps.airlines.data.AirlineModel;
import com.challenger.apps.airlines.data.StorageDB;

import javax.inject.Inject;

/**
 * Created by Challenger on 2/20/17.
 */

public class DetailsPresenter implements DetailsContract.Presenter {

    @Inject
    StorageDB storage;

    DetailsContract.View view;

    @Inject
    DetailsPresenter() {

    }

    @Override
    public void setView(DetailsContract.View view) {
        this.view = view;
    }

    @Override
    public void save(AirlineModel airlineModel) {
        storage.save(airlineModel);
    }

    @Override
    public boolean isSaved(String code) {
        return storage.isSaved(code);
    }

    @Override
    public void delete(String code) {
        storage.delete(code);
    }
}
