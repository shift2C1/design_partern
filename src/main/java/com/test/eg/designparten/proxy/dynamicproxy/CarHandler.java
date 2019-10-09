package com.test.eg.designparten.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CarHandler implements InvocationHandler {

    //需要代理的对象
    Object target=null;

    //保证代理的对象不空，构造函数里必须传
    public CarHandler(Object target){
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result=null;
        this.before();
        result=method.invoke(target,args);
        this.after();
        return result;
    }

    private void  before(){
        System.out.println("之前......");
//        System.out.println("");
    }
    private void after(){
        System.out.println("之后......");
    }
}
