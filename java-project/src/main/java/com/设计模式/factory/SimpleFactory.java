package com.设计模式.factory;

/**
 * 简单工厂模式（静态工厂方法模式）
 * 简单工厂模式的主要角色如下：
 * 简单工厂（SimpleFactory）：是简单工厂模式的核心，负责实现创建所有实例的内部逻辑。工厂类的创建产品类的方法可以被外界直接调用，创建所需的产品对象。
 * 抽象产品（Product）：是简单工厂创建的所有对象的父类，负责描述所有实例共有的公共接口。
 * 具体产品（ConcreteProduct）：是简单工厂模式的创建目标。
 * @author pengwei
 * @date 2020/12/22
 */
public class SimpleFactory {
    public static void main(String[] args) {
        Product car = new Car();
        Product product = getFacotry(car);
        product.info();


    }

    static Product getFacotry(Product product) {

        if (product.getClass() == Car.class) {
            return new Car();
        }
        if (product.getClass() == Plan.class) {
            return new Plan();
        }

        return null;
    }
}
