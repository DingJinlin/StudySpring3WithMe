package cn.javass.spring.chapter3.bean;

/**
 * Created by DingJinlin on 2016/11/19 21:02.
 *
 */
public class NavigationA {
    private NavigationB navigationB;

    public NavigationB getNavigationB() {
        return navigationB;
    }

    public void setNavigationB(NavigationB navigationB) {
        this.navigationB = navigationB;
    }
}
