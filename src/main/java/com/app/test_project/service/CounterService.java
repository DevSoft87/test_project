package com.app.test_project.service;

import org.springframework.stereotype.Service;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CounterService {

    private AtomicInteger count;

    public CounterService() {
        count = new AtomicInteger(50);
    }

    public void setValue(int value) {
        this.count.set(value);

    }

    public boolean isCorrectValue() {
        int c = count.get();
        return c < 100 && c > 0;
    }

    public int incrementValue() {
        return count.incrementAndGet();
    }

    public int decrementValue() {
        return count.decrementAndGet();
    }
}
