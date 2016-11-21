package cn.javass.spring.chapter4;

import cn.javass.spring.chapter4.bean.ResourceBean;
import cn.javass.spring.chapter4.bean.ResourceBean3;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by dingjinlin on 16-11-17.
 *
 */
public class ResourceInjectTest {

    @Test
    public void test() throws IOException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("chapter4/resourceInject.xml");
        ResourceBean3 resourceBean1 = ctx.getBean("resourceBean1", ResourceBean3.class);
        ResourceBean3 resourceBean2 = ctx.getBean("resourceBean2", ResourceBean3.class);
        Assert.assertTrue(resourceBean1.getResource() instanceof ClassPathResource);
        Assert.assertTrue(resourceBean2.getResource() instanceof ClassPathResource);
        InputStream is = resourceBean1.getResource().getInputStream();
        byte[] data = new byte[is.available()];
        int i = is.read(data);
        System.out.println(data.length);
    }
}
