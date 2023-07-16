public class MovieManager {
    private Movie[] movies;
    public final int limit;

    public MovieManager() {
        this.limit = 5;
        this.movies = new Movie[0];
    }

    public MovieManager(int limit) {
        this.limit = limit;
        this.movies = new Movie[0];
    }

    // Добавление нового фильма
    public void add(Movie movie) {
        // увеличиваем массив на 1 элемент
        Movie[] tmp = new Movie[movies.length + 1];
        // копируем старый массив в новый
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        // добавляем новый элемент
        tmp[tmp.length - 1] = movie;
        // сохраняем новый массив
        movies = tmp;
    }

    // Вывод всех фильмов
    public Movie[] findAll() {
        return movies;
    }

    // Вывод последних добавленных фильмов в обратном порядке
    public Movie[] findLast() {
        int resultLength = Math.min(movies.length, limit);
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - i - 1];
        }
        return result;
    }
}