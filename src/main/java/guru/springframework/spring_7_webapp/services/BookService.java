package guru.springframework.spring_7_webapp.services;

import guru.springframework.spring_7_webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
