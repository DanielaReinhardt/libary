package com.example.libary.controller;

import java.util.List;
import com.example.libary.entity.Book;
import com.example.libary.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> index() {
        return bookRepository.findAll();

    }

    @PostMapping("/books")
    public void createBook(@RequestParam String title, @RequestParam String author,
            @RequestParam String description) {
        if (title == null || author == null || description == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        bookRepository.save(new Book(title, author, description));
    }

    // PathVariable: variable im Adress-Pfad: localhost:8080/books/5
    // RequestParam: http request parameter in der URL, aber hinter Pfad:
    // localhost:8080/books?id=5

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable long id, @RequestParam String title, @RequestParam String author,
            @RequestParam String description){
        Book bookToUpdate = bookRepository.findById(id).get();
        if(author != null) 
        bookToUpdate.setAuthor(author);
        if(title != null)
        bookToUpdate.setTitle(title);
        if(description!= null)
        bookToUpdate.setDescription(description);
        return bookRepository.save(bookToUpdate);
                        }

    @GetMapping("/books/{id}")
    public Book findById(@PathVariable Long id) {
        return bookRepository.findById(id).get();
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }

    //find in title or description
    @GetMapping("/keyword")
    public String findByTitleLike(@RequestParam String keyword){
        //Book keywords = bookRepository.findAll(keyword)
       List<Book> keywords = bookRepository.findByTitleLike("%" + keyword + "%");
        return keywords.toString();
    }
}
