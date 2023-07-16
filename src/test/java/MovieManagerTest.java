import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieManagerTest {
    private MovieManager manager;
    private Movie first;
    private Movie second;
    private Movie third;
    private Movie fourth;
    private Movie fifth;
    private Movie sixth;

    @BeforeEach
    public void setUp() {
        manager = new MovieManager(3);
        first = new Movie(LocalDate.now());
        second = new Movie(LocalDate.now());
        third = new Movie(LocalDate.now());
        fourth = new Movie(LocalDate.now());
        fifth = new Movie(LocalDate.now());
        sixth = new Movie(LocalDate.now());
    }

    @Test
    public void shouldAddOneMovie() {
        manager.addMovie(first);

        List<Movie> expected = Arrays.asList(first);
        List<Movie> actual = manager.findAll();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddMultipleMovies() {
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);

        List<Movie> expected = Arrays.asList(first, second, third, fourth);
        List<Movie> actual = manager.findAll();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetAllMovies() {
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);

        List<Movie> expected = Arrays.asList(first, second, third);
        List<Movie> actual = manager.findAll();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetLastMovies() {
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);

        List<Movie> expected = Arrays.asList(sixth, fifth, fourth);
        List<Movie> actual = manager.findLast();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetLastMoviesWithinLimit() {
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);

        List<Movie> expected = Arrays.asList(fourth, third, second);
        List<Movie> actual = manager.findLast();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetLastMoviesWhenLimitIsEqualToNumberOfMovies() {
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);

        List<Movie> expected = Arrays.asList(third, second, first);
        List<Movie> actual = manager.findLast();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetLastMoviesWhenLimitIsZero() {
        manager = new MovieManager(0);

        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);

        List<Movie> expected = Arrays.asList();
        List<Movie> actual = manager.findLast();

        assertEquals(expected, actual);
    }
}