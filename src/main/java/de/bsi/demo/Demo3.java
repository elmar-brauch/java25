    void main() {
        ScopedValue<String> Y = ScopedValue.newInstance();

        Runnable thread = () -> {
            try {
                IO.println("Print scoped value: " + Y.get());
                IO.println("Is scoped value bound in main thread: " + Y.isBound());
            } catch (NoSuchElementException _) {
                IO.println("Scoped value was not bound to this tread.");
            }
        };

        ScopedValue.where(Y, "12345").run(thread);
        thread.run();
        IO.println("Is scoped value bound in main thread: " + Y.isBound());
    }