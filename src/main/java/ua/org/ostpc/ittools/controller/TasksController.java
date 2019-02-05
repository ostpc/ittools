/*
package ua.org.ostpc.ittools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.org.ostpc.ittools.dao.BookRepository;
import ua.org.ostpc.ittools.entity.Book;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class TasksController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public Iterable findAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/title/{bookTitle}")
    public List findByTitle(@PathVariable String bookTitle) {
        return bookRepository.findByTitle(bookTitle);
    }

    @GetMapping("/{id}")
    public Book findOne(@PathVariable Long id) {
        return bookRepository.findById(id)
                .orElseThrow(NullPointerException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookRepository.findById(id)
                .orElseThrow(NullPointerException::new);
        bookRepository.deleteById(id);
    }

    @GetMapping("/title/create/{bookTitle}/{author}")
    @ResponseStatus(HttpStatus.CREATED)
    public Book createDefault(@PathVariable String bookTitle, @PathVariable String author){
        Book book = new Book();
        book.setTitle(bookTitle);
        book.setAuthor(author);
        return  bookRepository.save(book);
    }
*/
/*
добавление книги и автора http://localhost:8080/api/books/title/create/book1/author1
*//*

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
        if (book.getId() != id) {
            throw new NullPointerException();
        }
        bookRepository.findById(id)
                .orElseThrow(NullPointerException::new);
        return bookRepository.save(book);
    }
}
*/
