package com.challenger.apps.airlines.dagger;

import com.challenger.apps.airlines.airlines.AirlinesFragment;
import com.challenger.apps.airlines.details.DetailsFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Challenger on 2/19/17.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface BaseComponent {
    void inject(AirlinesFragment airlinesFragment);
    void inject(DetailsFragment detailsFragment);
}
