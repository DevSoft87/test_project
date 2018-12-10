package com.app.test_project.model.dto;

import com.app.test_project.model.RequestType;

import static java.util.Objects.nonNull;

public class IncreaseThreadRequestDto implements Request{

    private Integer producerThreadCount;
    private Integer consumerThreadCount;

    public Integer getProducerThreadCount() {
        return producerThreadCount;
    }

    public void setProducerThreadCount(Integer producerThreadCount) {
        this.producerThreadCount = producerThreadCount;
    }

    public Integer getConsumerThreadCount() {
        return consumerThreadCount;
    }

    public void setConsumerThreadCount(Integer consumerThreadCount) {
        this.consumerThreadCount = consumerThreadCount;
    }

    @Override
    public String toString() {
        return "IncreaseThreadRequestDto{" +
                "producerThreadCount=" + producerThreadCount +
                ", consumerThreadCount=" + consumerThreadCount +
                '}';
    }

    @Override
    public RequestType getType() {
        return RequestType.COUNT_THREAD;
    }

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        if (nonNull(producerThreadCount) && producerThreadCount > 0) sb.append("Producer=").append(producerThreadCount);
        if (nonNull(consumerThreadCount) && consumerThreadCount > 0) sb.append("Consumer=").append(consumerThreadCount);

        return sb.toString();
    }
}
