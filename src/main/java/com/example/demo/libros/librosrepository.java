package com.example.demo.libros;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface librosrepository extends JpaRepository<libros, Integer> {
    // Buscar por nombre
    List<libros> findByName(String name);

    // Buscar por categoría
    List<libros> findByCategoria(String categoria);

    // Buscar por autor
    List<libros> findByAutor(String autor);

    // Buscar por género
    List<libros> findByGenero(String genero);

    // Buscar por nombre y categoría
    List<libros> findByNameAndCategoria(String name, String categoria);

    // Buscar por nombre, categoría y autor
    List<libros> findByNameAndCategoriaAndAutor(String name, String categoria, String autor);

    // Buscar por nombre, categoría, autor y género
    List<libros> findByNameAndCategoriaAndAutorAndGenero(String name, String categoria, String autor, String genero);
}