package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;



class MovieManagerTest {
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

    @Test
    void shouldManagerShowDefaultFilm() {
        MovieManager manager=new MovieManager();
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(four);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        Movie[] actual=manager.getFilms();
        Movie[] expected={tenth, ninth, eighth, seventh, sixth, fifth,four,third,second,first};
        assertArrayEquals(expected,actual);
    }
    @Test
    void shouldManagerShowFiveFilms(){
        MovieManager manager=new MovieManager(5);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(four);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        Movie[] actual=manager.getFilms();
        Movie[] expected={tenth, ninth, eighth, seventh, sixth};
        assertArrayEquals(expected,actual);
    }
    @Test
    void shouldManagerShowMinFilms(){
        MovieManager manager=new MovieManager(14);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(four);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(ninth);
        manager.add(twelfth);
        manager.add(thirteenth);


        Movie[] actual=manager.getFilms();
        Movie[] expected={thirteenth, twelfth, ninth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth,four,third,second,first};
        assertArrayEquals(expected,actual);
    }
    @Test
    void shouldManagerHaveAmountFilmsLessThenZero(){
        MovieManager manager=new MovieManager(-1);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(four);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(ninth);
        manager.add(twelfth);
        manager.add(thirteenth);

        Movie[] actual=manager.getFilms();
        Movie[] expected={thirteenth, twelfth, ninth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth};
        assertArrayEquals(expected,actual);

    }


}