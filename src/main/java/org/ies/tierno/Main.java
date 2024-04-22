package org.ies.tierno;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        int number = scanner.nextInt();
        scanner.nextLine();

        if(message != null && message.length() > 0) {
            System.out.println(message.charAt(0));
        }
    }
}