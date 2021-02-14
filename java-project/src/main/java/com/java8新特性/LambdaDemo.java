package com.java8新特性;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Lambda expression
 * @author pengwei
 * @date 2021/1/26
 */
public class LambdaDemo {
    public static void main(String[] args) {
        List<String> asList = Arrays.asList("aa", "bb", "cc");
        asList.forEach((result)->{
            System.out.println(result);
        });
        asList.forEach(System.out::println);

        //public static <T> void sort(List<T> list, Comparator<? super T> c) {
        //        list.sort(c);
        //    }
        // public static <T extends Comparable<? super T>> void  sort(List<T> list) {
        //        list.sort(null);
        //    }
        Collections.sort(asList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);

            }
        });
        Collections.sort(asList,(o1, o2)->{
            return o2.compareTo(o1);
        });

        Optional<Object> o =Optional.empty();


    }
}
