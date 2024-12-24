package SPP.s2labrab3.service;


import SPP.s2labrab3.config.DatabaseConfig;
import SPP.s2labrab3.dao.AuthorDAO;
import SPP.s2labrab3.dao.JournalDAO;
import SPP.s2labrab3.dao.PaperDAO;
import SPP.s2labrab3.model.Author;
import SPP.s2labrab3.model.Journal;
import SPP.s2labrab3.model.Paper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TestService
{
    private final AuthorDAO authorDAO = new AuthorDAO();
    private final JournalDAO journalDAO = new JournalDAO();
    private final PaperDAO paperDAO = new PaperDAO();

    public void populateDB() throws IOException
    {
        initDatabase();

        loadAuthors();
        loadJournals();
        loadPapers();
        loadAuthorJournalLinks();
    }

    @Deprecated
    public void deleteDatabase()
    {
        String deleteDatabaseSQL1 = "DROP TABLE authors";
        String deleteDatabaseSQL2 = "DROP TABLE journals";
        String deleteDatabaseSQL3 = "DROP TABLE papers";

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement())
        {
            stmt.executeUpdate(deleteDatabaseSQL3);
            stmt.executeUpdate(deleteDatabaseSQL1);
            stmt.executeUpdate(deleteDatabaseSQL2);

            System.out.println("База данных успешно удалена.");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void initDatabase()
    {
        String createAuthorsTable = "CREATE TABLE authors (id INT PRIMARY KEY, name VARCHAR(255))";
        String createJournalsTable = "CREATE TABLE journals (id INT PRIMARY KEY, title VARCHAR(255))";
        String createPapersTable = "CREATE TABLE papers (id INT PRIMARY KEY, title VARCHAR(255), journal_id INT, FOREIGN KEY (journal_id) REFERENCES journals(id))";
        String createAuthorJournalLinksTable = "CREATE TABLE author_journal_links (author_id INT, journal_id INT, " +
                "FOREIGN KEY (author_id) REFERENCES authors(id), " +
                "FOREIGN KEY (journal_id) REFERENCES journals(id), " +
                "PRIMARY KEY (author_id, journal_id))";

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement())
        {

            stmt.executeUpdate(createAuthorsTable);
            stmt.executeUpdate(createJournalsTable);
            stmt.executeUpdate(createPapersTable);
            stmt.executeUpdate(createAuthorJournalLinksTable);

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private void loadAuthors() throws IOException
    {
        List<String> lines = Files.readAllLines(Paths.get("src/main/resources/authors.txt"));
        for (String line : lines)
        {
            String[] parts = line.split(",");
            Author author = new Author();
            author.setId(Long.parseLong(parts[0]));
            author.setName(parts[1]);
            authorDAO.save(author);
        }
    }

    private void loadJournals() throws IOException
    {
        List<String> lines = Files.readAllLines(Paths.get("src/main/resources/journals.txt"));
        for (String line : lines)
        {
            String[] parts = line.split(",");
            Journal journal = new Journal();
            journal.setId(Long.parseLong(parts[0])); // Предполагается, что ID уже задан
            journal.setTitle(parts[1]);
            journalDAO.save(journal);
        }
    }

    private void loadPapers() throws IOException
    {
        List<String> lines = Files.readAllLines(Paths.get("src/main/resources/papers.txt"));
        for (String line : lines)
        {
            String[] parts = line.split(",");
            Paper paper = new Paper();
            paper.setId(Long.parseLong(parts[0]));
            paper.setTitle(parts[1]);
            Journal journal = new Journal();
            journal.setId(Long.parseLong(parts[2])); // Установка ID журнала
            paper.setJournal(journal);
            paperDAO.save(paper);
        }
    }

    private void loadAuthorJournalLinks() throws IOException
    {
        List<String> lines = Files.readAllLines(Paths.get("src/main/resources/author_journal_links.txt"));
        for (String line : lines)
        {
            String[] parts = line.split(",");
            Long authorId = Long.parseLong(parts[0]);
            Long journalId = Long.parseLong(parts[1]);

            String insertLinkSQL = "INSERT INTO author_journal_links (author_id, journal_id) VALUES (?, ?)";
            try (Connection conn = DatabaseConfig.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(insertLinkSQL))
            {
                pstmt.setLong(1, authorId);
                pstmt.setLong(2, journalId);
                pstmt.executeUpdate();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void printAllAuthors()
    {
        List<Author> authors = authorDAO.findAll();
        authors.forEach(author -> System.out.println(author.getName()));
    }

    public void printAllJournals()
    {
        List<Journal> journals = journalDAO.findAll();
        journals.forEach(journal -> System.out.println(journal.getTitle()));
    }

    public void printAllPapers() {
        List<Paper> papers = paperDAO.findAll();
        for (Paper paper : papers) {
            System.out.println("Title: " + paper.getTitle());

            // Вывод информации о журнале
            Journal journal = paper.getJournal();
            if (journal != null) {
                System.out.println("Journal: " + journal.getTitle());
            } else {
                System.out.println("Journal: Not specified");
            }

            // Вывод информации об авторах
            List<Author> authors = paper.getAuthors();
            if (authors != null && !authors.isEmpty()) {
                System.out.print("Authors: ");
                for (Author author : authors) {
                    System.out.print(author.getName() + ", ");
                }
                System.out.println(); // Переход на новую строку после списка авторов
            } else {
                System.out.println("Authors: Not specified");
            }

            System.out.println(); // Переход на новую строку между работами
        }
    }
}
