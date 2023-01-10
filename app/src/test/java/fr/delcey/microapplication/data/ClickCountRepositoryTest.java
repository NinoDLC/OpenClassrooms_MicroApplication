package fr.delcey.microapplication.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import fr.delcey.microapplication.LiveDataTestUtils;

public class ClickCountRepositoryTest {

    @Rule
    public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();

    private ClickCountRepository clickCountRepository;

    @Before
    public void setUp() {
        clickCountRepository = new ClickCountRepository();
    }

    @Test
    public void add() {
        // Given
        clickCountRepository.increase();

        // When
        Integer result = LiveDataTestUtils.getValueForTesting(clickCountRepository.getClickCountLiveData());

        // Then
        assertNotNull(result);
        assertEquals(1, result.intValue());
    }

    @Test
    public void addTwice() {
        // Given
        clickCountRepository.increase();
        clickCountRepository.increase();

        // When
        Integer result = LiveDataTestUtils.getValueForTesting(clickCountRepository.getClickCountLiveData());

        // Then
        assertNotNull(result);
        assertEquals(2, result.intValue());
    }

    @Test
    public void should_not_expose_data_by_default() {

        // When
        Integer result = clickCountRepository.getClickCountLiveData().getValue();

        // Then
        assertNull(result);
    }
}