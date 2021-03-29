package com.java8新特性;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * @author pengwei
 * @date 2021/3/8
 */
public class StreamDemo {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("张三", "李四", "王五");
//        stream.sorted().forEach(System.out::println);
     /*   stream.sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        }).forEach(System.out::println);*/
        
        stream.parallel().forEach(System.out::println);
    }
}
