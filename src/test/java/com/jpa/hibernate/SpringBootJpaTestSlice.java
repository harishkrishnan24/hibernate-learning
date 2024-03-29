package com.jpa.hibernate;


import com.jpa.hibernate.domain.Book;
import com.jpa.hibernate.repositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ComponentScan(basePackages = {"com.jpa.hibernate.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SpringBootJpaTestSlice {

    @Autowired
    BookRepository bookRepository;

    @Test
    @Order(1)
    @Commit
    void testJpaTestSlice() {

        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);

        bookRepository.save(new Book("My Book", "1233334", "Self", null));

        long countAfter = bookRepository.count();

        assertThat(countBefore).isLessThan(countAfter);
    }

    @Test
    @Order(2)
    void testJpaTestSliceTransaction() {

        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(3);


    }
}
