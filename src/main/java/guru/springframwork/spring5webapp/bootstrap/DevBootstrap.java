package guru.springframwork.spring5webapp.bootstrap;

import guru.springframwork.spring5webapp.model.Author;
import guru.springframwork.spring5webapp.model.Book;
import guru.springframwork.spring5webapp.model.Publisher;
import guru.springframwork.spring5webapp.repository.AuthorRepository;
import guru.springframwork.spring5webapp.repository.BookRepository;
import guru.springframwork.spring5webapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher publisherFumax = new Publisher("Fumax", "Budapest");
        Book ddd = new Book("Domain Driven Design", "1234", publisherFumax);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(publisherFumax);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher publisherDC = new Publisher("DC", "New York");
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisherDC);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        publisherRepository.save(publisherDC);
        bookRepository.save(noEJB);
    }
}
