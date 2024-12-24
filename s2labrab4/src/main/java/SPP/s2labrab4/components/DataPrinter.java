package SPP.s2labrab4.components;

import SPP.s2labrab4.model.Author;
import SPP.s2labrab4.model.Journal;
import SPP.s2labrab4.model.Paper;
import SPP.s2labrab4.repository.PaperRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataPrinter
{
    @Autowired
    private PaperRepository paperRepository;

    @PostConstruct
    public void run() throws Exception
    {
        List<Paper> papers = paperRepository.findAll();

        System.out.println("\nRetrieved Papers:");
        for (Paper paper : papers)
        {
            System.out.println("Title: " + paper.getTitle());

            Journal journal = paper.getJournal();
            if (journal != null)
            {
                System.out.println("Journal: " + journal.getTitle());
            } else
            {
                System.out.println("Journal: Not specified");
            }

            List<Author> authors = paper.getAuthors();
            if (authors != null && !authors.isEmpty())
            {
                System.out.print("Authors: ");
                for (Author author : authors)
                {
                    System.out.print(author.getName() + ", ");
                }
                System.out.println();
            } else
            {
                System.out.println("Authors: Not specified");
            }
            System.out.println();
        }
    }
}
