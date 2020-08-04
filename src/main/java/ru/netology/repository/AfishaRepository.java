package ru.netology.repository;

import ru.netology.domain.Movie;

public class AfishaRepository {
    private Movie[] movies = new Movie[0];
    private int amountFilms;
    private int defaultFilmCount = 10;

    public AfishaRepository() {
        this.amountFilms=defaultFilmCount;
    }

    public AfishaRepository(int amountFilms) {
        if (amountFilms >= 0) {
            this.amountFilms = amountFilms;
        } else {
            this.amountFilms = defaultFilmCount;
        }
    }
    public void save(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];

        System.arraycopy(movies, 0, tmp, 0, movies.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie[] findAll() {
        return movies;
    }

    public Movie findById(int id) {
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
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

    public Movie[] removeAll() {
        return new Movie[0];
    }

    public Movie[] getFilms() { // метод в котором можно задать количество выдаваемых афиш
        if (amountFilms >= movies.length) {
            amountFilms = movies.length;
        }
        Movie[] result = new Movie[amountFilms];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

}
