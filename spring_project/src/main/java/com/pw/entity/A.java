package com.pw.entity;

/**
 * @author pengwei
 * @date 2021/2/14
 */
public class A {
    private B b;

    public void setB(B b) {
        this.b = b;
    }

    public A() {
        System.out.println(" create  A  success!");
    }
}
