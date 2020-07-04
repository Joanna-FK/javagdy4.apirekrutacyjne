package com.sda.javagdy4_apirekrutacyjne;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        NBPApiParameters parameters = new NBPApiParameters();
        loadAndSetCurrency(scanner, parameters);
        loadAndSetEndDate(scanner, parameters);
        loadAndSetStartDate(scanner, parameters);
    }

    private static void loadAndSetStartDate(Scanner scanner, NBPApiParameters parameters) {
        do {
            System.out.println("Please enter start date [yyyy-MM-dd]:");
            try {
                parameters.setStartDate(scanner.nextLine());
            } catch (DateTimeParsingException e) {
                System.err.println("Wrong date: " + e.getMessage());
            }
        } while (parameters.getStartDate() == null);
    }

    private static void loadAndSetEndDate(Scanner scanner, NBPApiParameters parameters) {
        do {
            System.out.println("Please enter end date [yyyy-MM-dd]:");
            try {
                parameters.setEndDate(scanner.nextLine());
            } catch (DateTimeParsingException e) {
                System.err.println("Wrong date: " + e.getMessage());
            }
        } while (parameters.getEndDate() == null);
    }

    private static void loadAndSetCurrency(Scanner scanner, NBPApiParameters parameters) {
        do{
            System.out.println("Please enter currency [dollar, euro, rubel]:");
            Optional<NBPCurrency> optionalCurrency = NBPCurrency.parse(scanner.nextLine());
            if (optionalCurrency.isPresent()){
                parameters.setCurrency(optionalCurrency.get());
            } else{
                System.err.println("Error: currency is wrong, please correct");
            }
        }while (parameters.getCurrency()==null); // wykonuj pętle, dopóki currency == null
    }
}
