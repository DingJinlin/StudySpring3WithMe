package cn.javass.spring.chapter2;

import cn.javass.spring.chapter2.helloworld.HelloApi;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by DingJinlin on 2016/11/19.
 */
public class InstantiatingContainerTest {
    @Test
    public void testInstantiatingBeanByConstructor() {
//使用构造器
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter2/instantiatingBean.xml");
        HelloApi bean1 = beanFactory.getBean("bean1", HelloApi.class);
        bean1.sayHello();
        HelloApi bean2 = beanFactory.getBean("bean2", HelloApi.class);
        bean2.sayHello();
    }
}
