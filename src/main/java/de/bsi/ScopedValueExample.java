package de.bsi;

import java.util.NoSuchElementException;

public class ScopedValueExample {

    // Details in https://openjdk.org/jeps/506
    private static final ScopedValue<Integer> X = ScopedValue.newInstance();

    private static void printScopedValue() {
        IO.println("Instead of method-parameter a scoped value is used: " + X.get());
    }

    void main() {
        ScopedValue.where(X, 666).run(() -> printScopedValue());
        IO.println("Is scoped value bound in main thread: " + X.isBound());

        scopedValueExample2();
    }

    private void scopedValueExample2() {
        ScopedValue<String> Y = ScopedValue.newInstance();

        Runnable thread = () -> {
            try {
                IO.println("Print scoped value: " + Y.get());
            } catch (NoSuchElementException _) {
                IO.println("Scoped value was not bound to this tread.");
            }
        };

        ScopedValue.where(Y, "12345").run(thread);
        thread.run();
        IO.println("Is scoped value bound in main thread: " + Y.isBound());
    }

}
