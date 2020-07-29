package ru.netology.manager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MovieManagerTest {
    @Mock
    AfishaRepository repository;


    @InjectMocks
    AfishaManager manager;
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
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    void shouldRemoveIt() {
        int idToRemove = 1;

        Movie[] returned = new Movie[]{second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);


        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{third, second};


        assertArrayEquals(expected, actual);
        verify(repository).removeById(idToRemove);
    }

    @Test
    void shouldFindById(){
        int idToFind=2;

        Movie back=second;
        doReturn(back).when(repository).findById(idToFind);

        Movie actual = manager.findById(idToFind);
        Movie expected =second;

        assertEquals(expected, actual);
        verify(repository).findById(idToFind);

    }

   @Test
    void shouldRemoveAll(){
        Movie[] returned = new Movie[]{};
        doReturn(returned).when(repository).removeAll();

        Movie[] actual=manager.removeAll();
        Movie[] expected=new Movie[]{};

       assertArrayEquals(expected, actual);
       verify(repository).removeAll();

   }


}