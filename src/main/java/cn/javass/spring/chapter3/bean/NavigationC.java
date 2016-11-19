package cn.javass.spring.chapter3.bean;

/**
 * Created by DingJinlin on 2016/11/19 21:01.
 *
 */
public class NavigationC {
    private String msg;

    public NavigationC(String msg) {
        this.msg = msg;
    }

    public void sayNavigation() {
        System.out.println("===navigation c: " + msg);
    }
}
