package cn.javass.spring.chapter3.bean;

/**
 * Created by dingjinlin on 16-11-21.
 */
public class CircleB {
    private CircleC circleC;

    public CircleB() {
    }

    public CircleB(CircleC circleC) {
        this.circleC = circleC;
    }

    public void setCircleC(CircleC circleC) {
        this.circleC = circleC;
    }

    public void b() {
        System.out.println("B");
        circleC.c();
    }
}
