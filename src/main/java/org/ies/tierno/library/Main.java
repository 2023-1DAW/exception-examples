package org.ies.tierno.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {
    private final static Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = null;
        log.info("Introduzca el ISBN que desea buscar");
        String isbn = scanner.nextLine();
        try {
            Book book = library.findBook(isbn);
            log.info(book.toString());
        } catch (BookNotFoundException e) {
            log.error("No se ha podido encontrar el libro con isbn " + e.getIsbn());
        }
    }
}