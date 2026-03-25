package guru.springframework.spring_7_webapp.bookstrap;

import guru.springframework.spring_7_webapp.domain.Author;
import guru.springframework.spring_7_webapp.domain.Book;
import guru.springframework.spring_7_webapp.domain.Publisher;
import guru.springframework.spring_7_webapp.repositories.AuthorRepository;
import guru.springframework.spring_7_webapp.repositories.BookRepository;
import guru.springframework.spring_7_webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setFirstName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain driven design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        eric.setFirstName("Rod");
        eric.setFirstName("Johnson");

        Book noEJB= new Book();
        noEJB.setTitle("J2EE without EJB");
        noEJB.setIsbn("987654321");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        Publisher publisher = new Publisher();
        publisher.setAddress("Gilmerton Dykes Drive");
        publisher.setCity("Edinburgh");
        publisher.setPublisherName("Carrick Books");
        publisher.setState("Scotland");
        publisher.setZip("EH17 8LN");
        Publisher publisherSaved = publisherRepository.save(publisher);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);
        dddSaved.setPublisher(publisher);
        noEJBSaved.setPublisher(publisher);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        publisherRepository.save(publisher);

        System.out.println("In Bootstrap");
        System.out.println("Author Count:"+ authorRepository.count());
        System.out.println("Book Count:"+ bookRepository.count());
        System.out.println("Publisher Count:"+ publisherRepository.count());

    }

}
