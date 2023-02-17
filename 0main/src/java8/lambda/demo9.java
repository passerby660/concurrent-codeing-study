package java8.lambda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class demo9 {
    public static void main(String[] args) {

        Collection2<String> list = new ArrayList2<>();
        list.add("1");
        list.add("12");
        list.add("123");
        list.add("1234");
        list.add("12345");
        list.add("123456");
        list.forEachIf(System.out::println, e -> e.length() > 0);
    }

    interface Collection2<T> extends Collection<T> {

        default void forEachIf(Consumer<T> action, Predicate<T> filter) {
            Objects.requireNonNull(action);
            Objects.requireNonNull(filter);
//            for (T t : this) {
//                if (filter.test(t)){
//                    action.accept(t);
//                }
//            }
            this.stream().filter(filter).forEach(action::accept);
        }
    }

    static class ArrayList2<E> extends ArrayList<E> implements Collection2<E>{

    }
}
