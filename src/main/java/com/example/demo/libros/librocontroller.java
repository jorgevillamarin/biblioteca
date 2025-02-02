package com.example.demo.libros;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class librocontroller {

    private final librosservice libroservice;

    // Create a new book
    @PostMapping
    public void createBook(@RequestBody libros libro) {
        libroservice.createLibros(libro);
    }

    // Get all books
    @GetMapping
    public List<libros> getAllBooks() {
        return libroservice.getAllLibros();
    }

    @PostMapping("/search")
    public List<libros> searchLibros(@RequestBody Map<String, String> filters) {
        return libroservice.searchLibros(filters);
    }

    // Update a book by ID
    @PutMapping("/{id}")
    public void updateBook(@PathVariable Integer id, @RequestBody libros libro) {
        libroservice.updateLibro(id, libro);
    }

    // Delete a book by ID
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id) {
        libroservice.deleteLibro(id);
    }
}