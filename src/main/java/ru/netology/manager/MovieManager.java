package ru.netology.manager;

import ru.netology.domain.Movie;

import java.lang.module.FindException;

public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int amountFilms=10;

    public MovieManager(int amountFilms) {
        this.amountFilms = amountFilms;
    }

    public Movie[] getTenFilms(int amountFilms){ // метод в котором можно задать количество выдаваемых афиш
        Movie[] result = new Movie[amountFilms];
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

    public Movie[] getAll() {
        Movie[] result = new Movie[movies.length];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public void removeById(int id) {
        int length = movies.length - 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie movie : movies) {
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
        }
        movies = tmp;
    }

    public Movie[] getTenFilms(){ // метод по умолчанию выдает 10 афиш
        Movie[] result = new Movie[10];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public Movie[] getMoviesForFeed() {
        // TODO: add logic
        return null;
    }
}

