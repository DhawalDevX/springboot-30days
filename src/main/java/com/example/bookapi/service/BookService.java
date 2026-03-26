package com.example.bookapi.service;

import com.example.bookapi.config.BookMapper;
import com.example.bookapi.exception.BookNotFoundException;
import com.example.bookapi.model.Book;
import com.example.bookapi.repository.BookRepository;
import org.apache.catalina.LifecycleState;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private static final Logger logger= LoggerFactory.getLogger(BookService.class);

    // Constructor Injection
    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper= bookMapper;
    }

    // CREATE
    public Book addBook(Book book) {
        logger.info("Book add ho rhi hai");
        Book saved=bookRepository.save(book);
        logger.info("Book save hogyi with id "+saved.getId());
        return saved;
    }

    // READ ALL
    public Page<Book> getAllBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    // READ BY ID
    public Book getBookById(int id) throws BookNotFoundException {
        logger.info("Book is searching with id"+id);
        Book found= bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
        logger.info("Book mil gayi ID: " + id);
        return found;
    }

    // UPDATE
    public Book updateBook(int id, Book bookDetails) {
        logger.info("Book update suru");
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Book nahi mili ID: " + id);
                    return new BookNotFoundException("Book not found with id " + id);
                });
        existingBook.setTitle(bookDetails.getTitle());
        existingBook.setAuthor(bookDetails.getAuthor());
        existingBook.setPrice(bookDetails.getPrice());
        Book updated =bookRepository.save(existingBook);
        logger.info("Books updated with id"+id);
        return updated;
    }

    // DELETE
    public void deleteBook(int id) {
        logger.info("Book delete  ho rhi hai");
        if (!bookRepository.existsById(id)) {
            logger.error("Book ni mili with id "+id);
            throw new BookNotFoundException("Book not found with id " + id);
        }
        bookRepository.deleteById(id);
        logger.info("Book delete hi gyi");
    }
    public List<Book> searchByTitle(String title) {
        logger.info("Searching books with title"+ title);
        List<Book> books=bookRepository.findByTitleContaining(title);
        logger.info("Books mil gyi");
        return books;



    }
    public List<Book> findBooksCheaperThan(Double price) {
        logger.info("Finding books cheaper than price");
       List<Book> books=bookRepository.findBooksCheaperThan(price);
       logger.info("Found books cheaper than"+price);
       return books;
    }
}