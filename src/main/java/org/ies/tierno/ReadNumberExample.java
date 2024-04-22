package org.ies.tierno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadNumberExample {
    private static Scanner scanner = new Scanner(System.in);
    private static final Logger log = LoggerFactory.getLogger(ReadNumberExample.class);

    public static int readNumber() {
        Integer number = null;
        do {
            try {
                log.info("Introduce un número entero");
                number = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                log.error("El valor introducido no es un enetero");
                scanner.nextLine();
            }
        } while (number == null);
        return number;
    }

}