package de.bsi;

import module java.base;

/// # JEP 467
/// Java supports comments in Markdown format.
/// Other Java 25 JEPs in this class are:
/// * JEP 511
/// * JEP 456
/// * JEP 513
public class Java25 {

    Java25() {
        IO.println("Code before super() is allowed with JEP 513.");
        super();
        IO.println("Code after super() was allowed before.");
    }

    static void jep511_ModuleImport() {
        for (var item : List.of("1", 0))
            jep456_UnnamedVariable(item);
    }

    static void jep456_UnnamedVariable(Object obj) {
        try {
            switch (obj) {
                case String _ -> IO.println("Any Text.");
                case Integer number -> IO.println(10 / number);
                default -> IO.println("Unknown type");
            }
        } catch (Exception _) {
            IO.println("Exception caught without caring about details.");
        }
    }

    void main() {
        jep511_ModuleImport();
    }

}
