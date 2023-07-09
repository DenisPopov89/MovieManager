import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    @Test
    void shouldAddMovie() {
        MovieManager manager = new MovieManager();
        Movie movie = new Movie();
        manager.addMovie(movie);
        Movie[] expected = {movie};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void shouldFindAllMovies() {
        MovieManager manager = new MovieManager();
        Movie movie1 = new Movie();
        Movie movie2 = new Movie();
        manager.addMovie(movie1);
        manager.addMovie(movie2);
        Movie[] expected = {movie1, movie2};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void shouldFindLastMovies() {
        MovieManager manager = new MovieManager(2);
        Movie movie1 = new Movie();
        Movie movie2 = new Movie();
        Movie movie3 = new Movie();
        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);
        Movie[] expected = {movie3, movie2};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldFindAllMoviesWhenLimitExceedsSize() {
        MovieManager manager = new MovieManager(10);
        Movie movie1 = new Movie();
        Movie movie2 = new Movie();
        manager.addMovie(movie1);
        manager.addMovie(movie2);
        Movie[] expected = {movie1, movie2};
        assertArrayEquals(expected, manager.findLast());
    }
}