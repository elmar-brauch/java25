// Details in https://openjdk.org/jeps/485
void main() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);

    // Gatherers "fold" many to one mapping with keeping the Stream.
    // Prints 15 (Stream has only 1 element after gather)
    numbers.stream()
            .gather(Gatherers.fold(() -> 0, Integer::sum))
            .forEach(IO::println);

    // Gatherer "scan" takes current and previous value
    // and changes current value with given BiFunction (here sum as before)
    // Prints: [1, 3, 6, 10, 15]
    IO.println(numbers.stream()
            .gather(Gatherers.scan(() -> 0, (previous, current) -> previous + current))
            .toList());

    // "windowFixed" gathers elements in Stream in groups of elements with same size.
    // Prints: [[1, 2], [3, 4], [5]]
    List<List<Integer>> windows = numbers.stream()
            .gather(Gatherers.windowFixed(2))
            .toList();
    IO.println(windows);

    // "windowSliding" gathers elements in Stream in sliding-window groups.
    // Prints: [[1, 2], [2, 3], [3, 4], [4, 5]]
    List<List<Integer>> slidingWindows = numbers.stream()
            .gather(Gatherers.windowSliding(2))
            .toList();
    IO.println(slidingWindows);

    // "mapConcurrent" parallel mapping execution, which keeps the order
    // Prints: true
    IO.println(IntStream.range(0, 10000)
            .boxed()
            .gather(Gatherers.mapConcurrent(100, x -> x + 1))
            .gather(Gatherers.windowSliding(2))
            .allMatch(pair -> pair.getLast() - pair.getFirst() == 1));
}
