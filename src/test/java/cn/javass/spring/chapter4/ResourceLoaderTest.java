package cn.javass.spring.chapter4;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.*;

import java.io.IOException;

/**
 * Created by dingjinlin on 16-11-17.
 *
 */
public class ResourceLoaderTest {
    @Test
    public void testResourceLoad() throws IOException {
        ResourceLoader loader = new DefaultResourceLoader();
        Resource resource1 = loader.getResource("classpath:cn/javass/spring/chapter4/test1.txt");
        //验证返回的是ClassPathResource
        Assert.assertEquals(ClassPathResource.class, resource1.getClass());

        Resource resource2 = loader.getResource("file:cn/javass/spring/chapter4/test1.txt");
        //验证返回的是ClassPathResource
        Assert.assertEquals(UrlResource.class, resource2.getClass());

        Resource resource3 = loader.getResource("cn/javass/spring/chapter4/bean/test1.txt");
        //验证返默认可以加载ClasspathResource
        Assert.assertTrue(resource3 instanceof ClassPathResource);

        Resource resource4 = loader.getResource("META-INF/maven/commons-logging/commons-logging/pom.xml");
        Assert.assertTrue(resource4 instanceof ClassPathResource);

    }
}
