package com.example.demo.libros;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor // <-- Esto es lo que falta
@Entity

public class libros {
    @Id
    @GeneratedValue
    private Integer id;
    @Basic
    private String name;
    private String categoria;
    private Float  precio;
    private String genero;
    private String autor;
 

}
