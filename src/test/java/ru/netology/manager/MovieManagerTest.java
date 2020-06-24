package ru.netology.manager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    private MovieManager manager=new MovieManager();
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
    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.add(seven);
        manager.add(nine);
        manager.add(ten);
        manager.add(eleven);
        manager.add(twelve);
        manager.add(xix);
    }

    @Test
    void shouldTestIt() {
        int idToRemove = 5;

        manager.removeById(idToRemove);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{eight, seven, six, four, third, second, first};

        assertArrayEquals(expected, actual);


    }
    @Test
    void getTenFilms(){
        System.out.println(Arrays.toString(manager.getTenFilms(5)));
        System.out.println(Arrays.toString(manager.getTenFilms()));
    }

}