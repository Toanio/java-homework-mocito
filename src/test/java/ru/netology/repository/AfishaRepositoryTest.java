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
    Movie fifth = new Movie(5, "imageHostel", "Hostel Belgrad", "Genre1");
    Movie sixth = new Movie(6, "imageHostel", "Hostel Belgrad", "Genre1");
    Movie seventh = new Movie(7, "imageHostel", "Hostel Belgrad", "Genre1");
    Movie eighth = new Movie(8, "imageHostel", "Hostel Belgrad", "Genre1");
    Movie ninth = new Movie(9, "imageHostel", "Hostel Belgrad", "Genre1");
    Movie tenth = new Movie(10, "imageHostel", "Hostel Belgrad", "Genre1");
    Movie eleventh = new Movie(11, "imageHostel", "Hostel Belgrad", "Genre1");
    Movie twelfth = new Movie(12, "imageHostel", "Hostel Belgrad", "Genre1");
    Movie thirteenth = new Movie(13, "imageHostel", "Hostel Belgrad", "Genre1");

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
    void shouldFindByIdIfFoundNull() {
        int idToFind = 10;
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
    @Test
    void shouldManagerShowMinFilms(){
        AfishaRepository  repository=new AfishaRepository(14);
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(four);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
        repository.save(tenth);
        repository.save(eleventh);
        repository.save(ninth);
        repository.save(twelfth);
        repository.save(thirteenth);


        Movie[] actual=repository.getFilms();
        Movie[] expected={thirteenth, twelfth, ninth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth,four,third,second,first};
        assertArrayEquals(expected,actual);
    }
    @Test
    void shouldManagerShowDefaultFilm() {
        AfishaRepository  repository=new AfishaRepository();
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(four);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
        repository.save(tenth);

        Movie[] actual=repository.getFilms();
        Movie[] expected={tenth, ninth, eighth, seventh, sixth, fifth,four,third,second,first};
        assertArrayEquals(expected,actual);
    }
    @Test
    void shouldManagerShowFiveFilms(){
        AfishaRepository  repository=new AfishaRepository(5);
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(four);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
        repository.save(tenth);

        Movie[] actual=repository.getFilms();
        Movie[] expected={tenth, ninth, eighth, seventh, sixth};
        assertArrayEquals(expected,actual);
    }
    @Test
    void shouldManagerHaveAmountFilmsLessThenZero(){
        AfishaRepository  repository=new AfishaRepository(-1);
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(four);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
        repository.save(tenth);
        repository.save(eleventh);
        repository.save(ninth);
        repository.save(twelfth);
        repository.save(thirteenth);

        Movie[] actual=repository.getFilms();
        Movie[] expected={thirteenth, twelfth, ninth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth};
        assertArrayEquals(expected,actual);

    }

}