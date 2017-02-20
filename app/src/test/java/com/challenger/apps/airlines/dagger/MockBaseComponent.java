package com.challenger.apps.airlines.dagger;

import com.challenger.apps.airlines.AirlinesPresenterTest;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Challenger on 2/20/17.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface MockBaseComponent {
    void inject(AirlinesPresenterTest airlinesPresenterTest);
}
