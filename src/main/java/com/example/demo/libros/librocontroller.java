package com.example.demo.libros;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class librocontroller {

    private final librosservice libroservice;
    private final ExcelService excelService; // Nuevo servicio para generar Excel

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

    // Búsqueda dinámica
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

    // Exportar libros a Excel
    @PostMapping("/export")
    public ResponseEntity<ByteArrayResource> exportToExcel(@RequestBody Map<String, String> filters) throws IOException {
        // Obtener la lista de libros basada en los filtros
        List<libros> librosList = libroservice.searchLibros(filters);

        // Generar el archivo Excel
        byte[] excelBytes = excelService.generateExcel(librosList);

        // Preparar la respuesta para descargar el archivo
        ByteArrayResource resource = new ByteArrayResource(excelBytes);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=libros.xlsx")
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(resource);
    }
}