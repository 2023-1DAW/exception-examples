package org.ies.tierno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchExample {
    private static final Logger log = LoggerFactory.getLogger(TryCatchExample.class);
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            int numerator = askNumber("Introduce el numerador");

            int denominator = askNumber("Introduce el denominador");
            if (denominator != 0) {
                // invocamos a divide
                // Si se produce excepción el programa salta a los catch
                double res = divide(numerator, denominator);
                // Mostramos el resultado
                log.info("El resultado es: " + res);
            } else {
                log.error("No se puede dividir por cero");
            }

        } catch (InputMismatchException e) {
            // Si se produce InputMismatchException dentro del método askNumber lo capturamos aquí
            log.error("El número introducido es inválido", e);
        }
    }

    public static int askNumber(String message) {
        log.info(message);
        // Si el usuario introduce un valor no numérico provoca la excepción InputMismatchException
        // Como no hay try-catch se propaga al método que lo ha invocado
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public static double divide(int numerator, int denominator) {
        // Produce una excepción cuando denominator es 0
        // Como no hay try - catch se propaga al método que lo ha invocado
        return numerator / denominator;
    }
}
