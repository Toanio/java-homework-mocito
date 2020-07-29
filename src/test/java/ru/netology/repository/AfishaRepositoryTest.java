package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();
    Movie first = new Movie(1, "imageHostel", "Hostel Belgrad", "Genre1");
    Movie second = new Movie(2, "imageHostel", "Hostel Belgrad", "Genre1");
    Movie third = new Movie(3, "imageHostel", "Hostel Belgrad", "Genre1");
    Movie four = new Movie(4, "imageHostel", "Hostel Belgrad", "Genre1");

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(four);
    }

    @Test
    void shouldSave() {

        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second, third, four};

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindById() {
        int idToFind = 2;

        Movie actual = repository.findById(idToFind);
        Movie expected = second;

        assertEquals(expected, actual);

    }
    @Test
    void shouldFindByIdIfFoundNull(){
        int idToFind=10;
        Movie actual = repository.findById(idToFind);
        Movie expected = null;

        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        int idToRemove = 3;

        repository.removeById(idToRemove);

        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second, four};

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldRemoveAll() {

        Movie[] actual = repository.removeAll();
        Movie[] expected = new Movie[]{};
        assertArrayEquals(expected, actual);
    }

}