import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    @Test
    void shouldAddMovie() {
        // given
        MovieManager manager = new MovieManager();
        Movie movie = new Movie("The Shawshank Redemption");

        // when
        manager.addMovie(movie);

        // then
        Movie[] expected = {movie};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void shouldFindAllMovies() {
        // given
        MovieManager manager = new MovieManager();
        Movie movie1 = new Movie("The Shawshank Redemption");
        Movie movie2 = new Movie("The Godfather");
        manager.addMovie(movie1);
        manager.addMovie(movie2);

        // when
        Movie[] result = manager.findAll();

        // then
        Movie[] expected = {movie1, movie2};
        assertArrayEquals(expected, result);
    }

    @Test
    void shouldFindLastFiveMoviesByDefault() {
        // given
        MovieManager manager = new MovieManager();
        Movie[] movies = new Movie[]{
                new Movie("The Shawshank Redemption"),
                new Movie("The Godfather"),
                new Movie("The Dark Knight"),
                new Movie("12 Angry Men"),
                new Movie("Schindler's List"),
                new Movie("Forrest Gump")
        };
        for (Movie movie : movies) {
            manager.addMovie(movie);
        }

        // when
        Movie[] result = manager.findLast();

        // then
        Movie[] expected = {movies[5], movies[4], movies[3], movies[2], movies[1]};
        assertArrayEquals(expected, result);
    }

    @Test
    void shouldFindLastNMovies() {
        // given
        int limit = 3;
        MovieManager manager = new MovieManager(limit);
        Movie[] movies = new Movie[]{
                new Movie("The Shawshank Redemption"),
                new Movie("The Godfather"),
                new Movie("The Dark Knight"),
                new Movie("12 Angry Men"),
                new Movie("Schindler's List"),
                new Movie("Forrest Gump")
        };
        for (Movie movie : movies) {
            manager.addMovie(movie);
        }

        // when
        Movie[] result = manager.findLast();

        // then
        Movie[] expected = {movies[5], movies[4], movies[3]};
        assertArrayEquals(expected, result);
    }

    @Test
    void shouldFindAllMoviesWhenLimitExceedsSize() {
        // given
        int limit = 10;
        MovieManager manager = new MovieManager(limit);
        Movie[] movies = new Movie[]{
                new Movie("The Shawshank Redemption"),
                new Movie("The Godfather"),
                new Movie("The Dark Knight"),
                new Movie("12 Angry Men"),
                new Movie("Schindler's List"),
                new Movie("Forrest Gump")
        };
        for (Movie movie : movies) {
            manager.addMovie(movie);
        }

        // when
        Movie[] result = manager.findLast();

        // then
        Movie[] expected = {movies[5], movies[4], movies[3], movies[2], movies[1], movies[0]};
        assertArrayEquals(expected, result);
    }
}