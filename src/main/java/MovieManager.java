import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    private final List<Movie> movies;
    private final int limit;

    public MovieManager(int limit) {
        this.movies = new ArrayList<>();
        this.limit = limit;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> findAll() {
        return movies;
    }

    public List<Movie> findLast() {
        int size = Math.min(limit, movies.size());
        Movie[] resultArray = new Movie[size];
        for (int i = 0; i < size; i++) {
            resultArray[i] = movies.get(movies.size() - 1 - i);
        }
        return List.of(resultArray);
    }
}