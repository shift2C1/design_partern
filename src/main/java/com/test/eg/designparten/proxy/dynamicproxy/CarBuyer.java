package com.test.eg.designparten.proxy.dynamicproxy;

public class CarBuyer implements IBuyCar {

    //被代理的对象
    @Override
    public void doSomeThing() {
        System.out.println("真正的逻辑在执行.........");
    }
}
