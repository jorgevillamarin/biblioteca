package com.example.demo.libros;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class librosservice {

    private final librosrepository repolibro;

    // Crear un libro
    public void createLibros(libros libro) {
        repolibro.save(libro);
    }

    // Obtener todos los libros
    public List<libros> getAllLibros() {
        return repolibro.findAll();
    }

    // Obtener un libro por ID
    public libros getLibroById(Integer id) {
        Optional<libros> libroOptional = repolibro.findById(id);
        return libroOptional.orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

      // Búsqueda dinámica con filtros
      public List<libros> searchLibros(Map<String, String> filters) {
        String name = filters.get("name");
        String categoria = filters.get("categoria");
        String autor = filters.get("autor");
        String genero = filters.get("genero");

        if (name != null && categoria != null && autor != null && genero != null) {
            return repolibro.findByNameAndCategoriaAndAutorAndGenero(name, categoria, autor, genero);
        } else if (name != null && categoria != null && autor != null) {
            return repolibro.findByNameAndCategoriaAndAutor(name, categoria, autor);
        } else if (name != null && categoria != null) {
            return repolibro.findByNameAndCategoria(name, categoria);
        } else if (name != null) {
            return repolibro.findByName(name);
        } else if (categoria != null) {
            return repolibro.findByCategoria(categoria);
        } else if (autor != null) {
            return repolibro.findByAutor(autor);
        } else if (genero != null) {
            return repolibro.findByGenero(genero);
        } else {
            return repolibro.findAll(); // Si no se proporcionan filtros, devuelve todos los libros
        }
    }
    // Actualizar un libro por ID
    public void updateLibro(Integer id, libros libro) {
        libros libroExistente = getLibroById(id); // Verifica si el libro existe
        libroExistente.setName(libro.getName()); // Actualiza los campos necesarios
        libroExistente.setCategoria(libro.getCategoria());
        libroExistente.setPrecio(libro.getPrecio());
        libroExistente.setGenero(libro.getGenero());
        libroExistente.setAutor(libro.getAutor());
        repolibro.save(libroExistente); // Guarda los cambios
    }

    // Eliminar un libro por ID
    public void deleteLibro(Integer id) {
        libros libroExistente = getLibroById(id); // Verifica si el libro existe
        repolibro.delete(libroExistente); // Elimina el libro
    }
}