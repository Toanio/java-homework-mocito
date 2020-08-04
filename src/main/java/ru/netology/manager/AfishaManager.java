package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
    private AfishaRepository repository;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public void add(Movie movie) {
        repository.save(movie);
    }

    public Movie[] getAll() {
        Movie[] movies = repository.findAll();
        Movie[] result = new Movie[movies.length];

        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Movie findById(int id) {
        return repository.findById(id);
    }

    public Movie[] removeAll() {
        return repository.removeAll();
    }

    public Movie[] getFilms() { // метод в котором можно задать количество выдаваемых афиш
        return repository.getFilms();
    }
}

