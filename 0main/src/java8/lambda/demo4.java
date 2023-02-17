package java8.lambda;



public class demo4 {
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
