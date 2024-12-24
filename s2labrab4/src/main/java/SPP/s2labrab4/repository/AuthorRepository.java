package SPP.s2labrab4.repository;

import SPP.s2labrab4.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long>
{
}
