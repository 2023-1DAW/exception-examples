package org.ies.tierno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadFileExample {
    private static final Logger log = LoggerFactory.getLogger(ReadFileExample.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        log.info("Introduzca el path al fichero que desea leer");
        String file = scanner.nextLine();
        try {
            String firstLine = readFirstLine(file);
            log.info("La primera línea es " + firstLine);
        } catch (FileNotFoundException e) {
            log.error("No se ha encontrado el archivo " + file);
        } catch (IOException e) {
            log.error("No se ha podido leer la línea", e);
        }
    }

    public static String readFirstLine(String file) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        return reader.readLine();
    }
}
