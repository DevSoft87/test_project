package com.app.test_project.service;

import com.app.test_project.model.dto.IncreaseThreadRequestDto;
import com.app.test_project.service.logger.ThreadLogger;
import com.app.test_project.service.thread.ChangeCounterThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static java.util.Objects.nonNull;

@Service
public class ThreadContainer {

    @Autowired private CounterService counterService;
    @Autowired private RequestSaverService requestSaverService;
    @Autowired private ThreadLogger threadLogger;

    private int threadNumber = 0;

    public ThreadContainer() {

    }

    public void addThreads(IncreaseThreadRequestDto data) {
        if (nonNull(data)) {
            if (nonNull(data.getProducerThreadCount())) addProducerThread(data.getProducerThreadCount());
            if (nonNull(data.getConsumerThreadCount())) addConsumerThread(data.getConsumerThreadCount());
            requestSaverService.save(data);
        }
    }

    public void addProducerThread(int cnt) {
        Thread thread;
        for (int i = 0; i < cnt; i++) {
            thread = new ChangeCounterThread(counterService, ChangeCounterThread.TYPE_THREAD.PRODUCER, threadLogger);
            thread.setName(new StringBuilder("Producer").append(++threadNumber).toString());
            thread.start();
        }
    }

    public void addConsumerThread(int cnt) {
        Thread thread;
        for (int i = 0; i < cnt; i++) {
            thread = new ChangeCounterThread(counterService, ChangeCounterThread.TYPE_THREAD.CONSUMER, threadLogger);
            thread.setName(new StringBuilder("Consumer").append(++threadNumber).toString());
            thread.start();
        }

    }

}
