package lambda;

import java.lang.reflect.Method;
import java.util.function.BiFunction;

public class MethodReferencesExamples {
    public static <T> T mergeThings(T a, T b, BiFunction<T, T, T> merger) {
        return merger.apply(a, b);
    }

    public static String appendStrings(String a, String b) {
        return a + b;
    }

    public String appendStrings2(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {
        MethodReferencesExamples myApp = new MethodReferencesExamples();

        // Calling the method mergeThings with a lambda expression
        System.out.println(
                MethodReferencesExamples
                        .mergeThings("Hello ", "Word!", (a, b) -> a + b));

        // Reference to a static method
        System.out.println(
                MethodReferencesExamples
                        .mergeThings("Hello ", "Word!", MethodReferencesExamples::appendStrings));

        // Reference to an instance method of a particular object
        System.out.println(
                mergeThings("Hello ", "Word!", myApp::appendStrings2)
        );

        // Reference to an instance method of an arbitrary object of a particular type
        System.out.println(
                mergeThings("Hello ", "Word!", String::concat)
        );
    }
}
