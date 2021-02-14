package com.设计模式.factory;

/**
 * 工厂方法
 *
 * @author pengwei
 * @date 2020/12/22
 */
public class MethodFactory {
    interface ProductFactory {
        Product getProduct();
    }

    static class PlanFactory implements ProductFactory {
        @Override
        public Product getProduct() {
            return new Plan();
        }
    }

    static class CarFactory implements ProductFactory {
        @Override
        public Product getProduct() {
            return new Car();
        }
    }

    public static void main(String[] args) {
        ProductFactory planFactory = new PlanFactory();
        planFactory.getProduct().info();

    }
}
