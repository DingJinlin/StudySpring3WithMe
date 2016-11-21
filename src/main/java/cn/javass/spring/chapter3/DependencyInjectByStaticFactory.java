package cn.javass.spring.chapter3;

import cn.javass.spring.chapter2.helloworld.HelloApi;
import cn.javass.spring.chapter3.helloworld.HelloImpl3;

import java.beans.ConstructorProperties;

/**
 * Created by dingjinlin on 16-11-18.
 *
 */
public class DependencyInjectByStaticFactory {
    public static HelloApi newInstance(String message, int index) {
        return new HelloImpl3(message, index);
    }
}
