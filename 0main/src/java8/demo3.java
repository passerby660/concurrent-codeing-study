package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class demo3 {
    public static void main(String[] args) {
        int[] ints = new int[5];
        ints[0] = 7;
        ints[1] = 3;
        ints[2] = 9;
        ints[3] = 4;
        ints[4] = 8;
//        Arrays.sort(ints, Comparator::comparingInt);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
