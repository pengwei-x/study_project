package com.java8新特性;

/**
 * Default Methods for Interfaces
 * @author pengwei
 * @date 2021/1/26
 */
 interface  Animal{
     void eat();

    default void test(){
        System.out.println("java8新特性 接口默认方法");
    }
}
public class DefaultInterfaceDemo {

    public static void main(String[] args) {
        Animal animal = new Animal() {
            @Override
            public void eat() {
                System.out.println("eat.....");
            }
        };
        animal.eat();
        animal.test();
    }
}
