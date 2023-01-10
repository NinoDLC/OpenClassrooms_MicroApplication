package fr.delcey.microapplication.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ClickCountRepository {

    private final MutableLiveData<Integer> clickCountMutableLiveData = new MutableLiveData<>();

    public void increase() {
        Integer oldValue = clickCountMutableLiveData.getValue();

        if (oldValue == null) {
            oldValue = 0;
        }

        clickCountMutableLiveData.setValue(oldValue + 1);
    }

    @NonNull
    public LiveData<Integer> getClickCountLiveData() {
        return clickCountMutableLiveData;
    }
}
