package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

class PosterManagerTest {

    @Test
    void shouldAddFilm() {
        PosterManager manager = new PosterManager();

        manager.add("Film 1");

        assertArrayEquals(
                new String[]{"Film 1"},
                manager.findAll()
        );
    }

    @Test
    void shouldAddSeveralFilms() {
        PosterManager manager = new PosterManager();

        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");

        assertArrayEquals(
                new String[]{"Film 1", "Film 2", "Film 3"},
                manager.findAll()
        );
    }

    @Test
    void shouldReturnLastFilmsInReverseOrder() {
        PosterManager manager = new PosterManager(3);

        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");

        assertArrayEquals(
                new String[]{"Film 3", "Film 2", "Film 1"},
                manager.findLast()
        );
    }

    @Test
    void shouldReturnFiveLastFilmsByDefault() {
        PosterManager manager = new PosterManager();

        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");
        manager.add("Film 5");
        manager.add("Film 6");
        manager.add("Film 7");

        assertArrayEquals(
                new String[]{"Film 7", "Film 6", "Film 5", "Film 4", "Film 3"},
                manager.findLast()
        );
    }

    @Test
    void shouldReturnAllFilmsWhenThereAreLessThanLimit() {
        PosterManager manager = new PosterManager(5);

        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");

        assertArrayEquals(
                new String[]{"Film 3", "Film 2", "Film 1"},
                manager.findLast()
        );
    }

    @Test
    void shouldWorkWithCustomLimit() {
        PosterManager manager = new PosterManager(2);

        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");

        assertArrayEquals(
                new String[]{"Film 4", "Film 3"},
                manager.findLast()
        );
    }

    @Test
    void shouldCreateMockitoMock() {
        PosterManager manager = mock(PosterManager.class);

        when(manager.findAll()).thenReturn(
                new String[]{"Film 1", "Film 2"}
        );

        assertArrayEquals(
                new String[]{"Film 1", "Film 2"},
                manager.findAll()
        );

        verify(manager).findAll();
    }
}