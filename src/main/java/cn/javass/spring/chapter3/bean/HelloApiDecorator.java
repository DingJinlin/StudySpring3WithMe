package cn.javass.spring.chapter3.bean;

import cn.javass.spring.chapter2.helloworld.HelloApi;

/**
 * Created by DingJinlin on 2016/11/19 19:45.
 *
 */
public class HelloApiDecorator implements HelloApi {
    private HelloApi helloApi;

    //空参构造器
    public HelloApiDecorator() {
    }

    //有参构造器
    public HelloApiDecorator(HelloApi helloApi) {
        this.helloApi = helloApi;
    }

    public void setHelloApi(HelloApi helloApi) {
        this.helloApi = helloApi;
    }

    @Override
    public void sayHello() {
        System.out.println("==========装饰一下===========");
        helloApi.sayHello();
        System.out.println("==========装饰一下===========");
    }
}
