package com.app.test_project.service.thread;

import com.app.test_project.service.CounterService;
import com.app.test_project.service.logger.ThreadLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChangeCounterThread extends Thread {

    public enum TYPE_THREAD {
        PRODUCER,
        CONSUMER
    }

    private CounterService counterService;
    private TYPE_THREAD type;
    private ThreadLogger logger;

    public ChangeCounterThread(CounterService counter, TYPE_THREAD type, ThreadLogger logger) {
        this.counterService = counter;
        this.type = type;
        this.logger = logger;
    }

    @Override
    public void run() {
        while (counterService.isCorrectValue()) {
            try {
                int c = 0;
                switch (type) {
                    case PRODUCER: c = counterService.incrementValue(); break;
                    case CONSUMER: c = counterService.decrementValue(); break;
                }

                logger.add(this.getName() + " - value[" + c + "]");
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }
    }

}
