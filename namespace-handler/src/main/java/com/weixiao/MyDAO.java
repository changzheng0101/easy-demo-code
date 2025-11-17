package com.weixiao;

import java.util.List;

/**
 * @author changzheng
 * @date 2025年11月17日 09:58
 */
public class MyDAO {

    private List<String> fields;

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "MyDAO{" +
                "fields=" + fields +
                '}';
    }
}
