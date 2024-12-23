package SPP.s2labrab3.dao;

import SPP.s2labrab3.config.DatabaseConfig;
import SPP.s2labrab3.model.Author;
import SPP.s2labrab3.model.Journal;
import SPP.s2labrab3.model.Paper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaperDAO
{
    public void save(Paper paper)
    {
        String sql = "INSERT INTO papers (id, title, journal_id) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setLong(1, paper.getId());
            pstmt.setString(2, paper.getTitle());
            pstmt.setLong(3, paper.getJournal().getId());
            pstmt.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Paper> findAll() {
        List<Paper> papers = new ArrayList<>();
        String sql = "SELECT p.id AS paper_id, p.title AS paper_title, j.id AS journal_id, j.title AS journal_title " +
                "FROM papers p " +
                "JOIN journals j ON p.journal_id = j.id";

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Paper paper = new Paper();
                paper.setId(rs.getLong("paper_id"));
                paper.setTitle(rs.getString("paper_title"));

                // Создание объекта журнала
                Journal journal = new Journal();
                journal.setId(rs.getLong("journal_id"));
                journal.setTitle(rs.getString("journal_title"));
                paper.setJournal(journal);

                // Получение авторов
                List<Author> authors = findAuthorsByPaperId(paper.getId());
                paper.setAuthors(authors);

                papers.add(paper);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return papers;
    }

    private List<Author> findAuthorsByPaperId(long paperId) {
        List<Author> authors = new ArrayList<>();
        String sql = "SELECT a.id, a.name FROM authors a " +
                "JOIN author_journal_links ajl ON a.id = ajl.author_id " +
                "JOIN papers p ON ajl.journal_id = p.journal_id " +
                "WHERE p.id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, paperId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Author author = new Author();
                    author.setId(rs.getLong("id"));
                    author.setName(rs.getString("name"));
                    authors.add(author);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }
}

