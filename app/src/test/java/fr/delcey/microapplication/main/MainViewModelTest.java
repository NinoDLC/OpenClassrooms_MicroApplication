package fr.delcey.microapplication.main;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import fr.delcey.microapplication.LiveDataTestUtils;
import fr.delcey.microapplication.data.ClickCountRepository;

import static org.junit.Assert.assertEquals;

public class MainViewModelTest {

    @Rule
    public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();

    private ClickCountRepository clickCountRepository;

    private MutableLiveData<Integer> clickCountLiveData;

    private MainViewModel viewModel;

    @Before
    public void setUp() {
        clickCountLiveData = new MutableLiveData<>();
        clickCountRepository = Mockito.mock(ClickCountRepository.class);

        Mockito.doReturn(clickCountLiveData).when(clickCountRepository).getLiveData();

        viewModel = new MainViewModel(clickCountRepository);
    }

    @Test
    public void nominal_case() throws InterruptedException {
        // Given
        clickCountLiveData.setValue(1);

        // When
        String result = LiveDataTestUtils.getOrAwaitValue(viewModel.getClickCountLiveData());

        // Then
        assertEquals("1", result);
    }

    @Test
    public void given_100click_should_expose_100() throws InterruptedException {
        // Given
        clickCountLiveData.setValue(100);

        // When
        String result = LiveDataTestUtils.getOrAwaitValue(viewModel.getClickCountLiveData());

        // Then
        assertEquals("100", result);
    }

    @Test
    public void verifyOnButtonClicked() {
        // When
        viewModel.onButtonClicked();

        // Then
        Mockito.verify(clickCountRepository).add();
        Mockito.verifyNoMoreInteractions(clickCountRepository);
    }
}