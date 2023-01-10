package fr.delcey.microapplication;

import static org.junit.Assert.fail;

import androidx.lifecycle.LiveData;

public class LiveDataTestUtils {

    public static <T> T getValueForTesting(LiveData<T> liveData) {
        boolean[] called = {false};

        liveData.observeForever(value -> called[0] = true);

        if (!called[0]) {
            fail("LiveData was not called");
        }

        return liveData.getValue();
    }
}
