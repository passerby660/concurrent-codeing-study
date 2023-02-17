package java8.stream;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author elliott
 * @date 2023/2/16
 * @Desc
 **/
public class demo1 {
    public static void main(String[] args) {
//        List<String> words = new ArrayList<String>();
//        long count = words.stream().filter(e -> e.length() > 12).limit(2).count();

        Stream<BigInteger> stream = Stream.iterate(BigInteger.ZERO, a -> a.add(BigInteger.ONE)).limit(1000);
//        List<BigInteger> collect = stream.collect(Collectors.toList());
//        collect.forEach(System.out::println);
//        flatMap();
    }
    static Stream<Character> chaeacterStream(String str){
        List<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    static void flatMap(){
        Map<String, List<String>> listMap = new HashMap<String, List<String>>(){{
            put("a", new ArrayList<String>() {{
                add("aa");
                add("aaa");
            }});
            put("b", new ArrayList<String>() {{
                add("bb");
                add("bbb");
            }});
        }};
        List<String> collect = listMap.values().stream().flatMap(List::stream).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
