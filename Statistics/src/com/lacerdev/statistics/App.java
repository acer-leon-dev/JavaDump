package com.lacerdev.statistics;
import java.io.IOException;

public class App {
    boolean shouldEnd = false;

    void start() {
        while (!shouldEnd) {
            loop();
        }
    }

    void loop() {
        promptGeneralOptions();
    }

    void stop() {
        shouldEnd = true;
    }

    enum GeneralOptions {
        LISTS,
        DISTRIBUTIONS,
        EXIT,
        NULL;
    }

    void printGeneralOptions() {
        StringBuilder sb = new StringBuilder();
        sb.append("1. Lists\n");
        sb.append("2. Distributions\n");
        sb.append("0. Exit\n");
        System.out.println(s);
    }

    GeneralOptions readNextOption() {
        SystemInputBufferedReader reader = new SystemInputBufferedReader();
        int character;
        try {
            character = reader.read();
        } catch (IOException e) {
            System.out.println("Error: Failed to read number");
            return GeneralOptions.NULL;
        }

        int num =  character - '0';
        GeneralOptions o = switch (num) {
            case 1 -> GeneralOptions.LISTS;
            case 2 -> GeneralOptions.DISTRIBUTIONS;
            case 0 -> GeneralOptions.EXIT;
            default -> GeneralOptions.NULL;
        };

        if (o == GeneralOptions.NULL) {
            System.err.println("Error: \"" + (char)character + "\" is not a valid option.");
        }

        return o;
    }

    void promptGeneralOptions() {
        printGeneralOptions();
        System.out.print("$ ");
        GeneralOptions option = readNextOption();
        switch (option) {
//            case GeneralOptions.LISTS -> ;
//            case GeneralOptions.DISTRIBUTIONS -> ;
            case GeneralOptions.EXIT -> stop();
        }
    }

    
    void printListOptions() {

    }

    void promptListOptions() {

    }
}
