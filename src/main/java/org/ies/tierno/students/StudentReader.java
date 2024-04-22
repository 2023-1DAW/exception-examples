package org.ies.tierno.students;

import org.ies.tierno.TryCatchExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentReader {
    private static final Logger log = LoggerFactory.getLogger(StudentReader.class);

    private final Scanner scanner;

    public StudentReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Student read() {

        log.info("Introduzca el nif");
        String nif = scanner.nextLine();
        log.info("Introduzca el nombre");
        String name = scanner.nextLine();
        log.info("Introduzca el apellidos");
        String surname = scanner.nextLine();

        int zipCode = readPositiveInt("Introduce el código postal");

        return new Student(nif, name, surname, zipCode);
    }

    private int readPositiveInt(String message) {
        Integer number = null;
        do {
            number = readNumber(message);
            if(number < 0) {
                log.error("El valor no puede ser negativo");
            }
        } while (number < 0);
        return number;
    }

    private int readNumber(String message) {
        Integer number = null;
        do {
            try {
                log.info(message);
                number = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                log.error("El valor introducido no es un entero");
                scanner.nextLine();
            }
        } while (number == null);
        return number;
    }
}
