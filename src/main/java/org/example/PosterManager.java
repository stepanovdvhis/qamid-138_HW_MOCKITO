package org.example;

import java.util.Arrays;

public class PosterManager {

    private String[] films = new String[0];
    private final int limit;

    public PosterManager() {
        limit = 5;
    }

    public PosterManager(int limit) {
        this.limit = limit;
    }

    public void add(String film) {
        films = Arrays.copyOf(films, films.length + 1);
        films[films.length - 1] = film;
    }

    public String[] findAll() {
        return films;
    }

    public String[] findLast() {
        int resultLength = Math.min(films.length, limit);
        String[] result = new String[resultLength];

        for (int i = 0; i < resultLength; i++) {
            result[i] = films[films.length - 1 - i];
        }

        return result;
    }
}