
void main() {
    var list = new ArrayList<String>();
    while (list.size() < 2) {
        IO.print("Enter max 2 items in Console: ");
        list.add(IO.readln());
    }
    IO.println("Java 25 items are " + list);
}
