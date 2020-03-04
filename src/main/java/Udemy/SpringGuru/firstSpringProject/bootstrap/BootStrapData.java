package Udemy.SpringGuru.firstSpringProject.bootstrap;

import Udemy.SpringGuru.firstSpringProject.model.Author;
import Udemy.SpringGuru.firstSpringProject.model.Book;
import Udemy.SpringGuru.firstSpringProject.model.Publisher;
import Udemy.SpringGuru.firstSpringProject.repositories.AuthorRepository;
import Udemy.SpringGuru.firstSpringProject.repositories.BookRepository;
import Udemy.SpringGuru.firstSpringProject.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in bootstrap");

        Publisher swanPub = new Publisher("SwanPublishing", "Birdlane 65", "Birdville", "Illinois", "45604");


        publisherRepository.save(swanPub);

        Author paul = new Author("Paul", "Peeters");
        Book ddd = new Book("DoDieDove", "112233");

        paul.getBooks().add(ddd);
        ddd.getAuthors().add(paul);

        ddd.setPublisher(swanPub);
        swanPub.getBooks().add(ddd);

        authorRepository.save(paul);
        bookRepository.save(ddd);
        publisherRepository.save(swanPub);


        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "112233445566");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(swanPub);
        swanPub.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);


        System.out.println("Number of books " + bookRepository.count());
        System.out.println("Number of publishers " + publisherRepository.count());
        System.out.println("Number of publishers " + swanPub.getBooks().size());



    }
}
