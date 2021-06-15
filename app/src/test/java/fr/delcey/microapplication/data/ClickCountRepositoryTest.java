package fr.delcey.microapplication.data;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import fr.delcey.microapplication.LiveDataTestUtils;

import static org.junit.Assert.*;

public class ClickCountRepositoryTest {

    @Rule
    public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();

    private ClickCountRepository clickCountRepository;

    @Before
    public void setUp() {
        clickCountRepository = new ClickCountRepository();
    }

    @Test
    public void add() throws InterruptedException {
        // Given
        clickCountRepository.add();

        // When
        Integer result = LiveDataTestUtils.getOrAwaitValue(clickCountRepository.getLiveData());

        // Then
        assertNotNull(result);
        assertEquals(1, result.intValue());
    }

    @Test
    public void addTwice() throws InterruptedException {
        // Given
        clickCountRepository.add();
        clickCountRepository.add();

        // When
        Integer result = LiveDataTestUtils.getOrAwaitValue(clickCountRepository.getLiveData());

        // Then
        assertNotNull(result);
        assertEquals(2, result.intValue());
    }

    @Test
    public void should_not_expose_data_by_default() {

        // When
        Integer result = clickCountRepository.getLiveData().getValue();

        // Then
        assertNull(result);
    }
}