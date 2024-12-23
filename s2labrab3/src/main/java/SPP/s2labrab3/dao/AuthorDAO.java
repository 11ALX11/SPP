package SPP.s2labrab3.dao;

import SPP.s2labrab3.config.DatabaseConfig;
import SPP.s2labrab3.model.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO
{
    public void save(Author author) {
        String sql = "INSERT INTO authors (id, name) VALUES (?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, author.getId()); // Установка ID
            pstmt.setString(2, author.getName()); // Установка имени
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Author> findAll()
    {
        List<Author> authors = new ArrayList<>();
        String sql = "SELECT * FROM authors";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next())
            {
                Author author = new Author();
                author.setId(rs.getLong("id"));
                author.setName(rs.getString("name"));
                authors.add(author);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return authors;
    }
}