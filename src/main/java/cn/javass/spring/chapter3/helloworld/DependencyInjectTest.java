package cn.javass.spring.chapter3.helloworld;

import cn.javass.spring.chapter2.helloworld.HelloApi;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dingjinlin on 16-11-18.
 *
 */
public class DependencyInjectTest {
    @Test
    public void testConstructorDependencyInjectTest() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter3/constructorDependencyInject.xml");
        //获取根据参数索引依赖注入的Bean
        HelloApi byIndex = beanFactory.getBean("byIndex", HelloApi.class);
        byIndex.sayHello();

        //获取根据参数类型依赖注入的Bean
        HelloApi byType = beanFactory.getBean("byType", HelloApi.class);
        byType.sayHello();

        //获取根据参数名字依赖注入的Bean
        HelloApi byName = beanFactory.getBean("byName", HelloApi.class);
        byName.sayHello();

        //获取根据参数名字依赖注入的Bean
        HelloApi byName1 = beanFactory.getBean("byName1", HelloApi.class);
        byName1.sayHello();
    }
}
