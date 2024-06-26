package com.practice.Practice.bootstrap;

import com.practice.Practice.model.Author;
import com.practice.Practice.model.Book;
import com.practice.Practice.model.Publisher;
import com.practice.Practice.repository.AuthorRepository;
import com.practice.Practice.repository.BookRepository;
import com.practice.Practice.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author farid = new Author("Farid", "Mammadli");
        Author gabil = new Author("Qabil", "Qurbanov");

        Book farid_book = new Book("Heading1", "1231");
        Book gabil_book = new Book("Heading2", "1321");
        Publisher alinino = new Publisher("Ali Nino", "Ahmad bay Agaoglu str", "Baku", "", "1103");

        farid.getBooks().add(farid_book);
        gabil.getBooks().add(gabil_book);

        farid_book.getAuthors().add(farid);
        gabil_book.getAuthors().add(gabil);

        alinino.getBooks().add(farid_book);
        publisherRepository.save(alinino);
        farid_book.setPublisher(alinino);


        authorRepository.saveAll(Arrays.asList(farid,gabil));
        bookRepository.saveAll(Arrays.asList(farid_book,gabil_book));





//        authorRepository.save(farid);
//        authorRepository.save(gabil);
//
//        bookRepository.save(farid_book);
//        bookRepository.save(gabil_book);
    }
}
