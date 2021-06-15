package fr.delcey.microapplication.main;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Rule;
import org.junit.Test;

import fr.delcey.microapplication.LiveDataTestUtils;

import static org.junit.Assert.*;

public class MainViewModelTest {

    @Rule
    public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();

    @Test
    public void nominal_case() throws InterruptedException {
        // Given
        MainViewModel viewModel = new MainViewModel();

        // When
        viewModel.onButtonClicked();
        String result = LiveDataTestUtils.getOrAwaitValue(viewModel.getClickCountLiveData());

        // Then
        assertEquals("1", result);
    }

    @Test
    public void given_2clicks_should_expose_2() throws InterruptedException {
        // Given
        MainViewModel viewModel = new MainViewModel();

        // When
        viewModel.onButtonClicked();
        viewModel.onButtonClicked();
        String result = LiveDataTestUtils.getOrAwaitValue(viewModel.getClickCountLiveData());

        // Then
        assertEquals("2", result);
    }
}