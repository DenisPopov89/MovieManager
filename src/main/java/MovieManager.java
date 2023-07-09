public class MovieManager {
    private Movie[] movies;
    private int limit;

    public MovieManager() {
        this.movies = new Movie[0];
        this.limit = 10;
    }

    public MovieManager(int limit) {
        this.movies = new Movie[0];
        this.limit = limit;
    }

    public void addMovie(Movie movie) {
        int length = movies.length;
        Movie[] tmp = new Movie[length + 1];
        System.arraycopy(movies, 0, tmp, 0, length);
        tmp[length] = movie;
        movies = tmp;
    }

    public Movie[] findAll() {
        return movies;
    }

    public Movie[] findLast() {
        int resultLength;
        if (movies.length < limit) {
            resultLength = movies.length;
        } else {
            resultLength = limit;
        }
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - 1 - i];
        }
        return result;
    }
}