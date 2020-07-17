package ru.netology.manager;

import ru.netology.domain.Movie;

import java.lang.module.FindException;

public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int amountFilms = 10;
    private int defaultFilmCount=10;


    public MovieManager() {

    }

    public MovieManager(int amountFilms) {
        if (amountFilms >= 0) {
            this.amountFilms = amountFilms;
        }
    }

    public Movie[] getTenFilms() { // метод в котором можно задать количество выдаваемых афиш
        if (amountFilms <= movies.length) {
            if (amountFilms < 0) {
                amountFilms = defaultFilmCount;
            }
        }
        Movie[] result = new Movie[movies.length];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public void add(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];

        System.arraycopy(movies, 0, tmp, 0, movies.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }


}

