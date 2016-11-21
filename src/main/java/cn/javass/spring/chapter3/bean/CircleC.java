package cn.javass.spring.chapter3.bean;

/**
 * Created by dingjinlin on 16-11-21.
 *
 */
public class CircleC {
    private CircleA circleA;

    public CircleC() {
    }

    public CircleC(CircleA circleA) {
        this.circleA = circleA;
    }

    public void setCircleA(CircleA circleA) {
        this.circleA = circleA;
    }

    public void c() {
        System.out.println("C");
        circleA.a();
    }
}
