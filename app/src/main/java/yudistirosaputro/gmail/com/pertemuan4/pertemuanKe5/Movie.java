package yudistirosaputro.gmail.com.pertemuan4.pertemuanKe5;

/**
 * Created by blank15 on 11/04/2018.
 */

public class Movie {
    private String title,genre,year,rating;
    private int image;

    public Movie(String title, String genre, String year, String rating, int image) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
        this.image = image;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
