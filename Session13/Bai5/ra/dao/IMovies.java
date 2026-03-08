package Session13.Bai5.ra.dao;

import Session13.Bai5.ra.entity.Movies;

import java.util.List;

public interface IMovies {
    List <Movies> listMovies() ;// Liệt kê Phim
    void addMovies (Movies movies);// Thêm phim
    void editMovies (Movies movies,int editId); // Sửa phim
    void deleteMoviesByID (Integer moviesId);// Xóa phim
}
