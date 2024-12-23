package SPP.s2labrab3.dao;

import SPP.s2labrab3.config.DatabaseConfig;
import SPP.s2labrab3.model.Journal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JournalDAO
{
    public void save(Journal journal)
    {
        String sql = "INSERT INTO journals (id, title) VALUES (?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setLong(1, journal.getId());
            pstmt.setString(2, journal.getTitle());
            pstmt.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Journal> findAll()
    {
        List<Journal> journals = new ArrayList<>();
        String sql = "SELECT * FROM journals";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next())
            {
                Journal journal = new Journal();
                journal.setId(rs.getLong("id"));
                journal.setTitle(rs.getString("title"));
                journals.add(journal);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return journals;
    }
}
