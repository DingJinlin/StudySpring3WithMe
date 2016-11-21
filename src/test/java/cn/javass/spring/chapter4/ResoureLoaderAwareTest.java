package cn.javass.spring.chapter4;

import cn.javass.spring.chapter4.bean.ResourceBean;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by dingjinlin on 16-11-17.
 *
 */
public class ResoureLoaderAwareTest {

    @Test
    public void test() throws IOException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("chapter4/resourceLoaderAware.xml");
        ResourceBean resourceBean = ctx.getBean(ResourceBean.class);
        ResourceLoader loader = resourceBean.getResourceLoader();
        Assert.assertTrue(loader instanceof ApplicationContext);

        Resource resource4 = loader.getResource("META-INF/maven/commons-logging/commons-logging/pom.xml");
        if (resource4.exists()) {
            InputStream is = resource4.getInputStream();
            byte[] data = new byte[is.available()];
            is.read(data);
            System.out.println(data.length);
        }
        Assert.assertTrue(resource4 instanceof ClassPathResource);
    }


}
