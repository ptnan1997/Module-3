package Session13.Bai5.ra.dao;

import Session13.Bai5.JDBC.JDBC;
import Session13.Bai5.ra.entity.Movies;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieManager implements IMovies{

    @Override
    public List<Movies> listMovies() {
        List <Movies> movies = new ArrayList<>();
        // Bước 1: Mở kết nối
        Connection conn = JDBC.openConnection();
        // Bước 2: Tạo truy vấn bằng Callable
        try{
            CallableStatement call = conn.prepareCall("{call list_movies()}");
            // Bước 3: Thực thi truy vấn
            ResultSet rs = call.executeQuery();
            // Bước 4: Xử lý dữ liệu trả về
            while (rs.next()){
                Movies mv = new Movies(
                        rs.getString("title"),
                        rs.getString("director"),
                        rs.getInt("year")
                );
                mv.setMovieId(rs.getInt("movie_id"));
                movies.add(mv);
            }
            if (movies.isEmpty()){
                System.out.println("No movies found");
            } else {
                for (Movies mv : movies){
                    System.out.println(mv);
                }
            }
        } catch (SQLException e){
            throw  new RuntimeException(e);
        }
        return  movies;
    }

    @Override
    public void addMovies(Movies movies) {
        // Bước 1: Mở kết nối
        Connection conn = JDBC.openConnection();
        // Bước 2: Tạo truy vấn bằng Callable
        try{
            CallableStatement call = conn.prepareCall("{call add_movie(?,?,?)}");
            call.setString(1, movies.getTitle());
            call.setString(2, movies.getDirector());
            call.setInt(3, movies.getYear());
            // Bước 3: Thực thi truy vấn
            call.executeUpdate();
            System.out.println("Đã thêm phim thành công ✅");
        } catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }

    @Override
    public void editMovies(Movies movies, int editId) {
        // Bước 1: Mở kết nối
        Connection conn = JDBC.openConnection();
        // Bước 2: Tạo truy vấn bằng Callable
        try{
            CallableStatement call = conn.prepareCall("{call update_movie(?,?,?,?)}");
            call.setString(2, movies.getTitle());
            call.setString(3, movies.getDirector());
            call.setInt(4, movies.getYear());
            call.setInt(1, editId);
            // Bước 3: Thực thi truy vấn
            call.executeUpdate();
            System.out.println("Đã cập nhật thành công ✅");
        } catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }

    @Override
    public void deleteMoviesByID( Integer moviesId) {
        // Bước 1: Mở kết nối
        Connection conn = JDBC.openConnection();
        // Bước 2: Tạo truy vấn bằng Callable
        try{
            CallableStatement call = conn.prepareCall("{call delete_movie(?)}");
            call.setInt(1,moviesId);

            // Bước 3: Thực thi truy vấn
            call.executeUpdate();
            System.out.println("Đã xóa thành công✅");
        } catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }
}
