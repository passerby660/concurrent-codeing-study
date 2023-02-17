package java8.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

/**
 *
 */
public class demo1 {

    private static  final List<String> list = new ArrayList<String>(){{
        add("a");
        add("bb");
        add("ccc");
        add("dddd");
        add("eeeee");
        add("ffffff");
    }};

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        list.sort(Comparator.comparing(String::length).reversed());
        list.forEach(System.out::println);
    }


}
