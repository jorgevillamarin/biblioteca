# Biblioteca de Libros - Spring Boot API

## Descripción
API de Spring Boot para gestionar una biblioteca de libros que permite mostrar, agregar, actualizar, eliminar libros y exportarlos a Excel.

## Funcionalidades
- **GET http://localhost:8080/book**: Devuelve todos los libros.

- **POST http://localhost:8080/book/search**: Devuelve todos los libros segun el parametro indicado como primer argumento y segundo argumento como el contenido a buscar.
  como por ejmplo en el Reques body: {
  "autor": "Jorge villmarin"
}

- **POST http://localhost:8080/book**: Crear un libro.  Reques body: {
    "name": "Cien años de patria xd",
    "categoria": "realismo",
    "precio": 5.5,
    "genero": "bisexual",
    "autor": "Jorge villmarin"
}
- **PUT http://localhost:8080/book/1**: Actualiza un libro existente. Reques body: {
    "name": "Cien años de patria xd",
    "categoria": "realismo",
    "precio": 5.5,
    "genero": "bisexual",
    "autor": "Jorge villmarin"
}
- **DELETE http://localhost:8080/book/1**: Elimina un libro.
    
- **POST http://localhost:8080/book/export**: Exporta todos los libros a un archivo Excel filtrando por campo de busqueda al igual que la busqueda dinamica.
  ademas puedes usar este curl para guardar el excel en el directorio donde este la terminal: curl -X POST http://localhost:8080/book/export -H "Content-Type: application/json" -d '{"categoria": "realismo"}' --output libros.xlsx


## Tecnologías
- Spring Boot
- Java
- Maven
- H2 Database
- Apache POI
