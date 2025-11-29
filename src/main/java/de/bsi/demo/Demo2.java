package de.bsi.demo;

public class Demo2 {

    // Details in https://openjdk.org/jeps/506
    private static final ScopedValue<Integer> X = ScopedValue.newInstance();

    void main() {
        ScopedValue.where(X, 666).run(() -> printScopedValue());
        IO.println("Is scoped value bound in main thread: " + X.isBound());
    }

    private static void printScopedValue() {
        IO.println("Instead of method-parameter a scoped value is used: " + X.get());
    }

}
