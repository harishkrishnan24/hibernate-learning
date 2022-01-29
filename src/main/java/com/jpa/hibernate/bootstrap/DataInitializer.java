package com.jpa.hibernate.bootstrap;

import com.jpa.hibernate.domain.Book;
import com.jpa.hibernate.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book bookDDD = new Book("Domain Driven Design", "123", "RandomHouse");
        System.out.println("ID: " + bookDDD.getId());

        Book savedDDD = bookRepository.save(bookDDD);
        System.out.println("ID: " + bookDDD.getId());

        Book bookSIA = new Book("Spring in Action", "234234", "Oreily");
        Book savedBookSIA = this.bookRepository.save(bookSIA);

        bookRepository.findAll().forEach(book -> {
            System.out.println("Book Id: " + book.getId());
            System.out.println("Book Title: " + book.getTitle());
        });
    }
}
