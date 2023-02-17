package java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;

public class demo3 {
    public static void main(String[] args) {
        BiFunction<String, String, String> biFunction = (String first, String second) -> {
            return first.length() < second.length() ? second : first;
        };
        System.out.println(biFunction.apply("first", "second"));
    }
}
