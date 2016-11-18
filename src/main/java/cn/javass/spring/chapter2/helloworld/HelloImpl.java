package cn.javass.spring.chapter2.helloworld;

/**
 * Created by dingjinlin on 2016/11/18.
 */
public class HelloImpl implements HelloApi {
    @Override
    public void sayHello() {
        System.out.printf("Hello World!");
    }
}
