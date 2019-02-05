package ua.org.ostpc.ittools.dao;

import org.springframework.data.repository.CrudRepository;
import ua.org.ostpc.ittools.entity.Book;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
}
