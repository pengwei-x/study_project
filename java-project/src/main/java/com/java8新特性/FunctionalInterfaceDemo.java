package com.java8新特性;

import java.util.concurrent.Callable;

/**
 * @author pengwei
 * @date 2021/1/26
 */

@FunctionalInterface //exactly one abstract method
// 只能有一个抽象方法,这样的接口可以隐式转换为Lambda表达式 ,比如Runable 、Callable
interface MyFunctionalInterface {
    void test();
     default void testFunction(){
         System.out.println("funcationInterfance");
     }


}
public class FunctionalInterfaceDemo {

    public static void main(String[] args) {

    }
}
