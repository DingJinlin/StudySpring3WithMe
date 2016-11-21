package cn.javass.spring.chapter4;

import org.junit.Test;
import org.junit.Assert;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


import java.io.IOException;
import java.io.InputStream;


/**
 * Created by dingjinlin on 16-11-17.
 *
 */
public class TestResources {
//    public static void main(String[] args) {
//        TestResources ts = new TestResources();
//        try {
//            ts.testClasspathJarResourceByDefaultClassLoader();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void testClasspathResourceByDefaultClassLoader() throws IOException {
        Resource resource = new ClassPathResource("cn/javass/spring/chapter4/bean/test1.txt");
        if (resource.exists()) {
            dumpStream(resource);
        }

        System.out.println("path:" + resource.getFile().getAbsolutePath());
        Assert.assertEquals(false, resource.isOpen());
    }

    @Test
    public void testClasspathJarResourceByDefaultClassLoader() throws IOException {
        Resource resource = new ClassPathResource("META-INF/maven/commons-logging/commons-logging/pom.xml");
        if (resource.exists()) {
            dumpStream(resource);
        }

        System.out.println("URL:" + resource.getURL());
        Assert.assertEquals(false, resource.isOpen());
    }

    @Test
    public void testClasspathResourceByClassLoader() throws IOException {
        ClassLoader cl = this.getClass().getClassLoader();
        Resource resource = new ClassPathResource("cn/javass/spring/chapter4/bean/test1.txt", cl);

        if (resource.exists()) {
            dumpStream(resource);
        }
        System.out.println("path:" + resource.getFile().getAbsolutePath());
        Assert.assertEquals(false, resource.isOpen());
    }


    @Test
    public void testClasspathResourceByClass() throws IOException {
        Class clazz = this.getClass();
        Resource resource1 = new ClassPathResource("cn/javass/spring/chpater4/test1.txt", clazz);
        if (resource1.exists()) {
            dumpStream(resource1);
            System.out.println("path:" + resource1.getFile().getAbsolutePath());
            Assert.assertEquals(false, resource1.isOpen());
        }

        Resource resource2 = new ClassPathResource("test1.txt", this.getClass());
        if (resource2.exists()) {
            dumpStream(resource2);
            System.out.println("path:" + resource2.getFile().getAbsolutePath());
            Assert.assertEquals(false, resource2.isOpen());
        }
    }

    private void dumpStream(Resource resource) {
        InputStream is = null;
        try {
            //1.获取文件资源
            is = resource.getInputStream();
            //2.读取资源
            byte[] descBytes = new byte[is.available()];
            is.read(descBytes);
            System.out.println(new String(descBytes));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.关闭资源
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
