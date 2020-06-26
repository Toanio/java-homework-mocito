package ru.netology.manager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

class MovieManagerTest {
    AfishaManager manager=new AfishaManager(new AfishaRepository());
    Movie first = new Movie(1, "imageHostel", "Hostel Belgrad", "Genre1");
    Movie second = new Movie(2, "imageHostel", "Hostel Belgrad", "Genre1");
    Movie third = new Movie(3, "imageHostel", "Hostel Belgrad", "Genre1");
    Movie four = new Movie(4, "imageHostel", "Hostel Belgrad", "Genre1");
//    Movie five = new Movie(5, "imageHostel", "Hostel Belgrad", "Genre1");
//    Movie six = new Movie(6, "imageHostel", "Hostel Belgrad", "Genre1");
//    Movie seven = new Movie(7, "imageHostel", "Hostel Belgrad", "Genre1");
//    Movie eight = new Movie(8, "imageHostel", "Hostel Belgrad", "Genre1");
//    Movie nine = new Movie(9, "imageHostel", "Hostel Belgrad", "Genre1");
//    Movie ten = new Movie(10, "imageHostel", "Hostel Belgrad", "Genre1");
//    Movie eleven = new Movie(11, "imageHostel", "Hostel Belgrad", "Genre1");
//    Movie twelve= new Movie(12, "imageHostel", "Hostel Belgrad", "Genre1");
//    Movie xix= new Movie(13, "imageHostel", "Hostel Belgrad", "Genre1");

    @Mock
    AfishaRepository repository;

    @InjectMocks
    AfishaManager manager;

    @Test
    void shouldRemoveIt() {
        int idToRemove = 3;

        Movie[] returned = new Movie[]{first, second, four};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);


        Movie[] actual=manager.getAll();
        Movie[] expected= new Movie[]{first, second, four};


        assertArrayEquals(expected,actual);
    }


//    @Test
//    void shouldTestIt() {
//        int idToRemove = 5;
//
//        //manager.removeById(idToRemove);
//
//       // Movie[] actual = manager.getAll();
//        Movie[] expected = new Movie[]{eight, seven, six, four, third, second, first};
//
//        //assertArrayEquals(expected, actual);
//
//
//    }
//    @Test
//    void getTenFilms(){
////        System.out.println(Arrays.toString(manager.getTenFilms(5)));
////        System.out.println(Arrays.toString(manager.getTenFilms()));
//    }

}