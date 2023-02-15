package java8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author elliott
 * @date 2023/2/15
 * @Desc
 **/
public class demo8 {
    public static void main(String[] args) {
        String[] names = { "Peter","Paul","Mary" };
        List<Runnable> list = new ArrayList<>();
        for (String name : names) {
            list.add(() -> System.out.println(name));
        }
        list.forEach(Runnable::run);
        System.out.println("-----------------");

        List<Runnable> list2 = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            int finalI = i;
            list2.add(() -> System.out.println(names[finalI]));
        }
        list2.forEach(Runnable::run);
    }
}
