package SPP.s2labrab4.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "papers")
public class Paper
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "author_journal_links",
            joinColumns = @JoinColumn(name = "paper_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;
    @ManyToOne
    @JoinColumn(name = "journal_id")
    private Journal journal;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Journal getJournal()
    {
        return journal;
    }

    public void setJournal(Journal journal)
    {
        this.journal = journal;
    }

    public List<Author> getAuthors()
    {
        return authors;
    }

    public void setAuthors(List<Author> authors)
    {
        this.authors = authors;
    }
}
