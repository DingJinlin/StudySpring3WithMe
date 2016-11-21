package cn.javass.spring.chapter4;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by dingjinlin on 16-11-17.
 *
 */
public class ResourceMatchingTest {

    @Test
    public void testClasspathPrefix() throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath:META-INF/INDEX.LIST");
//        if (resources.length > 0 && resources[0].exists()) {
//            InputStream is = resources[0].getInputStream();
//            byte[] data = new byte[is.available()];
//            is.read(data);
//            System.out.println(resources[0].getURL());
//            System.out.println("Data: \n" + new String(data));
//        }
        Assert.assertEquals(1, resources.length);

        resources = resolver.getResources("classpath:META-INF/*.LIST");
//        if (resources.length > 0 && resources[0].exists()) {
//            InputStream is = resources[0].getInputStream();
//            byte[] data = new byte[is.available()];
//            is.read(data);
//            System.out.println("Data: \n" + new String(data));
//        }
        Assert.assertEquals(1, resources.length);
    }

    @Test
    public void testClasspathAsteriskPrefix() throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //将加载多个绝对匹配的所有Resource
        //将首先通过ClassLoader.getResources("META-INF")加载非模式路径部分
        //然后进行遍历模式匹配
        Resource[] resources = resolver.getResources("classpath*:META-INF/INDEX.LIST");
        Assert.assertTrue(resources.length > 1);

        //将加载多个模式匹配的Resource
        resources = resolver.getResources("classpath*:META-INF/*.LIST");
        Assert.assertTrue(resources.length > 1);
    }
}
