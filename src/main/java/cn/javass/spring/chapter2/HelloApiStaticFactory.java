package cn.javass.spring.chapter2;

import cn.javass.spring.chapter2.helloworld.HelloApi;

/**
 * Created by DingJinlin on 2016/11/19.
 *
 */
public class HelloApiStaticFactory {
    //工厂方法
    public static HelloApi newInstance(String message) {
        //返回需要的Bean实例
        return new HelloImpl2(message);
    }
}
