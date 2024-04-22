package org.ies.tierno.library;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class Library {
    private String name;
    private Map<String, Book> books;

    // Este método lanza y propaga la excepcióin BookNotFoundException
    public Book findBook(String isbn) throws BookNotFoundException {
        if(books.containsKey(isbn)) {
            return books.get(isbn);
        } else{
            // Lanzamos la excepción si no existe el libro
            throw new BookNotFoundException(isbn);
        }
    }
}