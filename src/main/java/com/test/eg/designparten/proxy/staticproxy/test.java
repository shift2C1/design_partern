package com.test.eg.designparten.proxy.staticproxy;

public class test {
    public static void main(String[] args) {
        RealSubject realSubject=new RealSubject();
        Proxy proxy=new Proxy(realSubject);

        //由代理类真正的执行
        proxy.request();
    }
}
