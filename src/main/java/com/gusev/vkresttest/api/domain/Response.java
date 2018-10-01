package com.gusev.vkresttest.api.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Response<T> implements Serializable {

    private Integer count;
    private List<T> items;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
