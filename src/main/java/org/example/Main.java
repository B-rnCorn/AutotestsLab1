package org.example;



import org.example.ultimateCalculator.ConsoleInputController;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static boolean isSwitchedOff(String input) {
        return Objects.equals(input, "exit");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstInput = "", secondInput = "", operation = "";

        while (true) {
            System.out.println("Enter first number");
            firstInput = scanner.nextLine();

            if(isSwitchedOff(firstInput)) return;

            System.out.println("Enter operation (+-/*)");
            operation = scanner.nextLine();

            if(isSwitchedOff(firstInput)) return;

            System.out.println("Enter second number");
            secondInput = scanner.nextLine();

            if(isSwitchedOff(firstInput)) return;

            System.out.println("Result: " + ConsoleInputController.applyOperation(firstInput, secondInput, operation));
        }
    }
}