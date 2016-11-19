package cn.javass.spring.chapter3.bean;

import java.util.List;
import java.util.Map;

/**
 * Created by DingJinlin on 2016/11/19 19:06.
 *
 */
public class ListTestBean {
    private List<String> values;
    private String[] stringValues;
    private Map mpaValues;

    public List<String> getValues() {
        return values;
    }
    public void setValues(List<String> values) {
        this.values = values;
    }

    public String[] getStringValues() {
        return stringValues;
    }

    public void setStringValues(String[] stringValues) {
        this.stringValues = stringValues;
    }

    public Map getMpaValues() {
        return mpaValues;
    }

    public void setMpaValues(Map mpaValues) {
        this.mpaValues = mpaValues;
    }
}
