package com.test.eg.designparten.proxy.staticproxy;

public class RealSubject implements ISubject {


    //处理具体的业务
    @Override
    public void request() {
        System.out.println("处理具体的业务........");
    }
}
