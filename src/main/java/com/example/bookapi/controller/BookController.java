package com.example.bookapi.controller;

import com.example.bookapi.dto.BookDTO;
import com.example.bookapi.model.Book;
import com.example.bookapi.service.BookService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final ModelMapper modelMapper;

    public BookController(BookService bookService, ModelMapper modelMapper) {
        this.bookService = bookService;
        this.modelMapper = modelMapper;
    }

    // ================= CREATE =================
    @PostMapping
    public ResponseEntity<BookDTO> addBook(@Valid @RequestBody BookDTO dto) {

        // DTO → Entity
        Book book = modelMapper.map(dto, Book.class);

        // Call Service (Service expects Book)
        Book savedBook = bookService.addBook(book);

        // Entity → DTO
        BookDTO responseDTO = modelMapper.map(savedBook, BookDTO.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    // ================= READ ALL =================
    @GetMapping
    public ResponseEntity<Page<BookDTO>> getAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Pageable pageable= PageRequest.of(page,size, Sort.by(sortBy));

        Page<Book> books = bookService.getAllBooks(pageable);
        Page<BookDTO> response= books.map(this::convertToDTO);


        return ResponseEntity.ok(response);
    }
    private BookDTO convertToDTO(Book book) {
        return modelMapper.map(book,BookDTO.class);
    }

    // ================= READ BY ID =================
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable int id) {

        Book book = bookService.getBookById(id);

        BookDTO dto = modelMapper.map(book, BookDTO.class);

        return ResponseEntity.ok(dto);
    }

    // ================= UPDATE =================
    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable int id, @Valid @RequestBody BookDTO dto) {

        // DTO → Entity
        Book book = modelMapper.map(dto, Book.class);

        // Service update
        Book updatedBook = bookService.updateBook(id, book);

        // Entity → DTO
        BookDTO responseDTO = modelMapper.map(updatedBook, BookDTO.class);

        return ResponseEntity.ok(responseDTO);
    }

    // ================= DELETE =================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {

        bookService.deleteBook(id);

        return ResponseEntity.noContent().build();
    }
    @GetMapping("/search")
    public ResponseEntity<List<BookDTO>> searchBooks(@RequestParam String title) {
        List<Book> books=bookService.searchByTitle(title);
        List<BookDTO> response=new ArrayList<>();
        for(Book book: books) {
            response.add(modelMapper.map(book,BookDTO.class));
        }
        return ResponseEntity.ok(response);


    }
    @GetMapping("/cheaper")
    public ResponseEntity<List<BookDTO>> getCheaperBooks(
            @RequestParam Double price) {
        List<Book> books = bookService.findBooksCheaperThan(price);
        List<BookDTO> response = new ArrayList<>();
        for (Book book : books) {
            response.add(modelMapper.map(book, BookDTO.class));
        }
        return ResponseEntity.ok(response);
    }
}