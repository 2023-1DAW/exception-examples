package org.ies.tierno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExample {
    private static final Logger log = LoggerFactory.getLogger(ExceptionExample.class);

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int number1 = askInteger();
        int number2 = askIntegerNotZero();
        if (number2 == 0) {
            log.error("No se puede dividir por 0");
        } else {
            int res = number1 / number2;
            log.info("La división es " + res);
        }
    }

    public static int askIntegerNotZero() {
        int number = askInteger();
        while (number == 0) {
            log.error("El número no puede ser cero");
            number = askInteger();
        }
        return number;
    }

    public static int askInteger() {
        Integer number = null;
        while (number == null) {
            try {
                log.info("Introduce un número entero");
                number = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                log.error("El valor introducido no es un entero", e);
            }
        }
        return number;
    }
}
