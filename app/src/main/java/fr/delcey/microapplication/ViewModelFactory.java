package fr.delcey.microapplication;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import fr.delcey.microapplication.data.ClickCountRepository;
import fr.delcey.microapplication.main.MainViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private static ViewModelFactory factory;

    public static ViewModelFactory getInstance() {
        if (factory == null) {
            synchronized (ViewModelFactory.class) {
                if (factory == null) {
                    factory = new ViewModelFactory(
                        new ClickCountRepository()
                    );
                }
            }
        }

        return factory;
    }

    @NonNull
    private final ClickCountRepository clickCountRepository;

    public ViewModelFactory(@NonNull ClickCountRepository clickCountRepository) {
        this.clickCountRepository = clickCountRepository;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(
                clickCountRepository
            );
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
