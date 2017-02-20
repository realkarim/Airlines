package com.challenger.apps.airlines;

import com.challenger.apps.airlines.airlines.AirlinesContract;
import com.challenger.apps.airlines.airlines.AirlinesPresenter;
import com.challenger.apps.airlines.dagger.DaggerMockBaseComponent;
import com.challenger.apps.airlines.dagger.MockAppModule;
import com.challenger.apps.airlines.data.AirlineModel;
import com.challenger.apps.airlines.data.StorageDB;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

/**
 * Created by Challenger on 2/20/17.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class AirlinesPresenterTest {

    @Inject
    AirlinesPresenter airlinesPresenter;

    @Inject
    StorageDB storageDB;

    @Before
    public void setUp() {
        DaggerMockBaseComponent.builder()
                .appModule(new MockAppModule(RuntimeEnvironment.application))
                .build()
                .inject(this);
    }

    @Test
    public void testLoadingAirlines(){
        final CountDownLatch signal = new CountDownLatch(1);

        AirlinesContract.View  view = new AirlinesContract.View() {
            @Override
            public void onAirlinesDataReceived(ArrayList airlinesList) {
                Assert.assertNotNull(airlinesList);
                Assert.assertEquals(airlinesList.size(), 2);
                signal.countDown(); // notify the count down latch
            }

            @Override
            public void showMessage(String message) {

            }
        };

        airlinesPresenter.setView(view);
        airlinesPresenter.getAirlines();

        try {
            signal.await();
        } catch (InterruptedException e) {
            Assert.fail();
        }
    }

    @Test
    public void testLoadingFavoriteAirlines(){
        final CountDownLatch signal = new CountDownLatch(1);



        AirlineModel airlineModel0 = new AirlineModel();
        airlineModel0.setCode("0");
        airlineModel0.setUsName("0");
        airlineModel0.setSite("0");
        airlineModel0.setPhone("0");
        AirlineModel airlineModel1 = new AirlineModel();
        airlineModel0.setCode("1");
        airlineModel0.setUsName("1");
        airlineModel0.setSite("1");
        airlineModel0.setPhone("1");

        storageDB.save(airlineModel0);
        storageDB.save(airlineModel1);

        AirlinesContract.View  view = new AirlinesContract.View() {
            @Override
            public void onAirlinesDataReceived(ArrayList airlinesList) {
                Assert.assertNotNull(airlinesList);
                Assert.assertEquals(airlinesList.size(), 2);
                signal.countDown(); // notify the count down latch
            }

            @Override
            public void showMessage(String message) {

            }
        };

        airlinesPresenter.setView(view);
        airlinesPresenter.getFavorites();


        try {
            signal.await();
        } catch (InterruptedException e) {
            Assert.fail();
        }
    }

}
