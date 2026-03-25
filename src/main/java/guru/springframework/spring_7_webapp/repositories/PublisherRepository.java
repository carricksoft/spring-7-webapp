package guru.springframework.spring_7_webapp.repositories;

import guru.springframework.spring_7_webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
