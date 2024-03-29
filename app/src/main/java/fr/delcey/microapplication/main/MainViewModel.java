package fr.delcey.microapplication.main;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import fr.delcey.microapplication.data.ClickCountRepository;

public class MainViewModel extends ViewModel {

    @NonNull
    private final ClickCountRepository clickCountRepository;

    public MainViewModel(@NonNull ClickCountRepository clickCountRepository) {
        this.clickCountRepository = clickCountRepository;
    }

    public void onButtonClicked() {
        clickCountRepository.increase();
    }

    public LiveData<String> getClickCountLiveData() {
        return Transformations.map(clickCountRepository.getClickCountLiveData(), clickCount -> "Tu as cliqué " + clickCount + " fois");
    }
}
