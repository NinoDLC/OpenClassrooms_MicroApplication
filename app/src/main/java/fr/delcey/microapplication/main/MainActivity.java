package fr.delcey.microapplication.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import fr.delcey.microapplication.R;
import fr.delcey.microapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getClickCountLiveData().observe(this, clickCount ->
            binding.mainTextviewCount.setText(clickCount)
        );

        binding.mainButton.setOnClickListener(view -> viewModel.onButtonClicked());
    }
}