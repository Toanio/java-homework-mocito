package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import java.util.Arrays;


class MovieManagerTest {
    Movie first = new Movie(1, "imageHostel", "Hostel Belgrad", "Genre1");
    Movie second = new Movie(2, "imageHostel", "Hostel Belgrad", "Genre1");
    Movie third = new Movie(3, "imageHostel", "Hostel Belgrad", "Genre1");
    Movie four = new Movie(4, "imageHostel", "Hostel Belgrad", "Genre1");
    Movie five = new Movie(5, "imageHostel", "Hostel Belgrad", "Genre1");
    Movie six = new Movie(6, "imageHostel", "Hostel Belgrad", "Genre1");
    Movie seven = new Movie(7, "imageHostel", "Hostel Belgrad", "Genre1");
    Movie eight = new Movie(8, "imageHostel", "Hostel Belgrad", "Genre1");
    Movie nine = new Movie(9, "imageHostel", "Hostel Belgrad", "Genre1");
    Movie ten = new Movie(10, "imageHostel", "Hostel Belgrad", "Genre1");
    Movie eleven = new Movie(11, "imageHostel", "Hostel Belgrad", "Genre1");
    Movie twelve= new Movie(12, "imageHostel", "Hostel Belgrad", "Genre1");
    Movie xix= new Movie(13, "imageHostel", "Hostel Belgrad", "Genre1");

    @Test
    void shouldManagerShowDefaultFilm() {
        MovieManager manager=new MovieManager();
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.add(seven);
        manager.add(eight);
        manager.add(nine);
        manager.add(ten);

        Movie[] actual=manager.getFilms();
        Movie[] expected={ten,nine,eight,seven,six,five,four,third,second,first};
        assertArrayEquals(expected,actual);
    }
    @Test
    void shouldManagerShowFiveFilms(){
        MovieManager manager=new MovieManager(5);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.add(seven);
        manager.add(eight);
        manager.add(nine);
        manager.add(ten);

        Movie[] actual=manager.getFilms();
        Movie[] expected={ten,nine,eight,seven,six};
        assertArrayEquals(expected,actual);
    }
    @Test
    void shouldManagerShowMinFilms(){
        MovieManager manager=new MovieManager(14);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.add(seven);
        manager.add(eight);
        manager.add(nine);
        manager.add(ten);
        manager.add(eleven);
        manager.add(nine);
        manager.add(twelve);
        manager.add(xix);


        Movie[] actual=manager.getFilms();
        Movie[] expected={xix,twelve,nine,eleven,ten,nine,eight,seven,six,five,four,third,second,first};
        assertArrayEquals(expected,actual);
    }


}