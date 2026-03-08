package Session13.Bai5.ra.entity;

public class Movies {
    private int movieId;
    private String title;
    private String director;
    private int year;
    // Constructor không tham số
    public Movies(){}
    // Constructor có tham số
    public Movies( String title, String director, int year) {
        this.title = title;
        this.director = director;
        this.year = year;
    }
    // Phương thức Getter and Setter

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", year=" + year +
                '}';
    }
}
