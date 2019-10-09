package com.test.eg.designparten.proxy.staticproxy;

public class Proxy implements ISubject {

    private ISubject iubject=null;
    //要代理的对象传入代理类
    public Proxy(ISubject iSubject){
        this.iubject=iSubject;
    }
    //拓展业务
    @Override
    public void request() {
        //代理类负责拓展业务
        this.before();
        //真正的逻辑操作还是有委托类执行
        iubject.request();
        //代理类负责拓展业务
        this.after();
    }

    private void before(){
        System.out.println("执行业务之前.......");
    }
    private void after(){
        System.out.println("执行业务之后........");
    }
}
