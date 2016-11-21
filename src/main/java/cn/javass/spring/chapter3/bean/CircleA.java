package cn.javass.spring.chapter3.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;

/**
 * Created by dingjinlin on 16-11-21.
 */
public class CircleA {
    private CircleB circleB;

    public CircleA() {
    }

    public CircleA(CircleB circleB) {
        this.circleB = circleB;
    }

    public void setCircleB(CircleB circleB) {
        this.circleB = circleB;
    }

    public void a() {
        System.out.println("A");
        circleB.b();
    }
}
