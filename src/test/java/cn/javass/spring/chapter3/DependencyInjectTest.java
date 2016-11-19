package cn.javass.spring.chapter3;

import cn.javass.spring.chapter2.helloworld.HelloApi;
import cn.javass.spring.chapter3.bean.IdRefTestBean;
import cn.javass.spring.chapter3.bean.ListTestBean;
import cn.javass.spring.chapter3.bean.NavigationA;
import cn.javass.spring.chapter3.bean.NavigationC;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by DingJinlin on 2016/11/19.
 *
 */
public class DependencyInjectTest {

    @Test
    public void testSetDependencyInject() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter3/setterDependencyInject.xml");
        HelloApi bean = beanFactory.getBean("bean", HelloApi.class);
        bean.sayHello();
    }

    @Test
    public void testIdRefInject() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter3/idRefInject.xml");
        IdRefTestBean bean1 = beanFactory.getBean("idrefBean1", IdRefTestBean.class);
        System.out.println("bean id:" + bean1.getId());

        IdRefTestBean bean2 = beanFactory.getBean("idrefBean2", IdRefTestBean.class);
        System.out.println("bean id:" + bean2.getId());
    }

    @Test
    public void testListInject() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter3/listInject.xml");
        ListTestBean listBean = beanFactory.getBean("listBean", ListTestBean.class);
        System.out.println(listBean.getValues().size());
        Assert.assertEquals(3, listBean.getValues().size());

        System.out.println(listBean.getStringValues().length);
        Assert.assertEquals(4, listBean.getStringValues().length);

        System.out.println(listBean.getMpaValues().size());
        Assert.assertEquals(5, listBean.getMpaValues().size());
    }

    @Test
    public void testBeanInject() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter3/beanInject.xml");

        //通过构造器方式注入
        HelloApi bean1 = beanFactory.getBean("bean1", HelloApi.class);
        bean1.sayHello();

        //通过setter方式注入
        HelloApi bean2 = beanFactory.getBean("bean2", HelloApi.class);
        bean2.sayHello();
    }

    @Test
    public void testInnerBeanInject() {
        ApplicationContext context = new ClassPathXmlApplicationContext("chapter3/innerBeanInject.xml");
        HelloApi bean = context.getBean("bean", HelloApi.class);
        bean.sayHello();
    }

    //对象图导航
    @Test
    public void testNavigationBeanInject() {
        ApplicationContext context = new ClassPathXmlApplicationContext("chapter3/navigationBeanInject.xml");
        NavigationA navigationA = context.getBean("a", NavigationA.class);
        navigationA.getNavigationB().getNavigationC().sayNavigation();
        navigationA.getNavigationB().getList().get(0).sayNavigation();
        navigationA.getNavigationB().getMap().get("key").sayNavigation();
        ((NavigationC) navigationA.getNavigationB().getProperties().get("0")).sayNavigation();
        ((NavigationC) navigationA.getNavigationB().getProperties().get("1")).sayNavigation();
        navigationA.getNavigationB().getArray()[0].sayNavigation();
        navigationA.getNavigationB().getArray()[1].sayNavigation();
        navigationA.getNavigationB().getArray()[2].sayNavigation();
    }
}
