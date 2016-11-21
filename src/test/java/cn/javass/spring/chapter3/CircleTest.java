package cn.javass.spring.chapter3;

import cn.javass.spring.chapter3.bean.CircleA;
import org.junit.Test;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * Created by dingjinlin on 16-11-21.
 */
public class CircleTest {
    @Test(expected = BeanCurrentlyInCreationException.class)
    public void testCircleByConstructor() throws Throwable {
        try {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("chapter3/circleInjectByConstructor.xml");
        } catch (Exception e) {
            //因为要在创建circle3时抛出；
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1;
        }
    }

    @Test(expected = BeanCurrentlyInCreationException.class)
    public void testCircleBySetterAndPrototype () throws Throwable {
        try {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("chapter3/circleInjectBySetterAndPrototype.xml");
            System.out.println(ctx.getBean("circleA"));
        }
        catch (Exception e) {
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1;
        }
    }

    @Test(expected = BeanCurrentlyInCreationException.class)
    public void testCircleBySetterAndSingleton2() throws Throwable {
        try {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
            ctx.setConfigLocation("chapter3/circleInjectBySetterAndSingleton.xml");
            ctx.setAllowCircularReferences(false);
            ctx.refresh();
        }
        catch (Exception e) {
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1;
        }
    }
}
