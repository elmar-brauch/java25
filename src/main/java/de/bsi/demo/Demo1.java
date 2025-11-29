package de.bsi.demo;

import java.util.List;

// TODO 3. JEP 512 Make this script for beginners.
public class Demo1 {

    public static void main(String[] args) {
        // TODO 1. JEP 511 Use module import for List
        for (Object item : List.of("1", 0)) {

            try {
                switch (item) {
                    case String ignoredText -> IO.println("Any Text.");
                    case Integer number -> IO.println(10 / number);
                    default -> IO.println("Unknown type");
                }
                // TODO 2. JEP 456 Use unnamed variable
            } catch (Exception doNotCareException) {
                IO.println("Exception caught without caring about details.");
            }
        }

    }

}
