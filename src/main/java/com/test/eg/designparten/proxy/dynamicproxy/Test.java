package com.test.eg.designparten.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {


        CarBuyer carBuyer=new CarBuyer();
        try {
            IBuyCar iBuyCar= (IBuyCar) Proxy.newProxyInstance(carBuyer.getClass().getClassLoader(),carBuyer.getClass().getInterfaces(),new CarHandler(carBuyer));
            iBuyCar.doSomeThing();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
