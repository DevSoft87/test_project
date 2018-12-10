package com.app.test_project.model.dto;

import com.app.test_project.model.RequestType;

public class CounterDto implements Request{

    private Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CounterDto{" +
                "value=" + value +
                '}';
    }

    @Override
    public RequestType getType() {
        return RequestType.COUNTER;
    }

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        return sb.toString();
    }
}
