package behavioral;

import java.util.ArrayList;
import java.util.List;

class Movie{
    public String id;
    public String genre;
    public List<String> languages;
    Movie(String id, String genre, List<String> languages) {
        this.id = id;
        this.genre = genre;
        this.languages = languages;
    }
}

class BookMyShow {
    private List<Movie> movies;
    BookMyShow() { this.movies = new ArrayList<>(); }
    void addMovie(Movie movie) { this.movies.add(movie); }

    public List<Movie> search(SearchType type, String inp) {
        if(type == SearchType.GENRE) {
            SearchStrategy strategy = new SearchByGenre(movies, inp);
            return strategy.search();
        } else if(type == SearchType.LANGUAGE) {
            SearchStrategy strategy = new SearchByLanguage(movies, inp);
            return strategy.search();
        }
        return movies;
    }
}

enum SearchType { GENRE, LANGUAGE }
interface SearchStrategy {
    public List<Movie> search();
}

class SearchByGenre implements SearchStrategy {
    private List<Movie> movies;
    private String genre;
    SearchByGenre(List<Movie> movies, String genre) { this.movies = movies; this.genre = genre; }
    @Override
    public List<Movie> search() {
        return movies.stream().filter(m -> m.genre.equals(genre)).toList();
    }
}

class SearchByLanguage implements SearchStrategy {
    private List<Movie> movies;
    private String language;
    SearchByLanguage(List<Movie> movies, String language) { this.movies = movies; this.language = language; }
    @Override
    public List<Movie> search() {
        return movies.stream().filter(m -> m.languages.contains(language)).toList();
    }
}

public class strategy {
    public static void main(String[] args) {
        Movie m1 = new Movie("1", "Action", List.of("English", "French"));
        Movie m2 = new Movie("2", "Comedy", List.of("English"));
        Movie m3 = new Movie("3", "Action", List.of("French"));

        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.addMovie(m1);
        bookMyShow.addMovie(m2);
        bookMyShow.addMovie(m3);

        bookMyShow.search(SearchType.LANGUAGE, "English").forEach(m -> System.out.println(m.id));
    }
}
