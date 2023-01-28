package java8;

import java.util.function.BiFunction;

public class demo2 {
    public static void main(String[] args) {
        BiFunction<String, String, String> biFunction = (String first, String second) -> {
            return first.length() < second.length() ? second : first;
        };
        System.out.println(biFunction.apply("first", "second"));
    }

}
