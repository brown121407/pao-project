package xyz._121407.school_management;

import xyz._121407.school_management.entities.HighSchool;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

public class CLI {
    private static Set<HighSchool> highSchools;

    public static void run() {
        var scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            try {
                var line = scanner.nextLine();
                parseCommand(line);
            } catch (NoSuchElementException ex) {
                break;
            }
        }
    }

    private static void parseCommand(String command) {
        var segments = command.split(" ");
        if (segments.length == 0) {
            throw new RuntimeException("Empty command.");
        }

        System.out.println(Arrays.toString(segments));
    }
}
