package cn.javass.spring.chapter2;

import cn.javass.spring.chapter2.helloworld.HelloApi;

/**
 * Created by DingJinlin on 2016/11/19.
 *
 */
public class HelloApiInstanceFactory {
    public HelloApi newInstance(String message) {
        return new HelloImpl2(message);
    }
}
