package guru.springframwork.spring5webapp.repository;

import guru.springframwork.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
