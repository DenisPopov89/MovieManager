import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {
    @Test
    public void testAdd() {
        MovieManager manager = new MovieManager();
        manager.add(new Movie("Movie 1"));
        manager.add(new Movie("Movie 2"));
        Movie[] movies = manager.findAll();
        Assertions.assertArrayEquals(new Movie[] {
                new Movie("Movie 1"),
                new Movie("Movie 2")
        }, movies);
    }

    @Test
    public void testFindAll() {
        MovieManager manager = new MovieManager();
        manager.add(new Movie("Movie 1"));
        manager.add(new Movie("Movie 2"));
        Movie[] movies = manager.findAll();
        Assertions.assertArrayEquals(new Movie[] {
                new Movie("Movie 1"),
                new Movie("Movie 2")
        }, movies);
    }

    @Test
    public void testFindLast() {
        MovieManager manager = new MovieManager(3);
        manager.add(new Movie("Movie 1"));
        manager.add(new Movie("Movie 2"));
        manager.add(new Movie("Movie 3"));
        manager.add(new Movie("Movie 4"));
        manager.add(new Movie("Movie 5"));
        Movie[] movies = manager.findLast();
        Assertions.assertArrayEquals(new Movie[] {
                new Movie("Movie 5"),
                new Movie("Movie 4"),
                new Movie("Movie 3")
        }, movies);
    }

    @Test
    public void shouldAddMovies() {
        MovieManager manager = new MovieManager();
        manager.add(new Movie("Movie 1"));
        manager.add(new Movie("Movie 2"));
        Movie[] movies = manager.findAll();
        Assertions.assertArrayEquals(new Movie[] {
                new Movie("Movie 1"),
                new Movie("Movie 2")
        }, movies);
    }

    @Test
    public void shouldFindAllMovies() {
        MovieManager manager = new MovieManager();
        manager.add(new Movie("Movie 1"));
        manager.add(new Movie("Movie 2"));
        Movie[] movies = manager.findAll();
        Assertions.assertArrayEquals(new Movie[] {
                new Movie("Movie 1"),
                new Movie("Movie 2")
        }, movies);
    }

    @Test
    public void shouldFindLastFiveMoviesByDefault() {
        MovieManager manager = new MovieManager();
        manager.add(new Movie("Movie 1"));
        manager.add(new Movie("Movie 2"));
        manager.add(new Movie("Movie 3"));
        manager.add(new Movie("Movie 4"));
        manager.add(new Movie("Movie 5"));
        Movie[] movies = manager.findLast();
        Assertions.assertArrayEquals(new Movie[] {
                new Movie("Movie 5"),
                new Movie("Movie 4"),
                new Movie("Movie 3"),
                new Movie("Movie 2"),
                new Movie("Movie 1")
        }, movies);
    }
}