package fr.delcey.microapplication.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private final MutableLiveData<Integer> clickCountMutableLiveData = new MutableLiveData<>();

    public void onButtonClicked() {
        Integer oldValue = clickCountMutableLiveData.getValue();

        if (oldValue == null) {
            oldValue = 0;
        }

        int newValue = oldValue + 1;

        clickCountMutableLiveData.setValue(newValue);
    }

    public LiveData<String> getClickCountLiveData() {
        return Transformations.map(clickCountMutableLiveData, clickCount -> "" + clickCount);
    }

}
