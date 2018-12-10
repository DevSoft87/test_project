package com.app.test_project.service.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Logging implements Runnable {

    private ConcurrentLinkedQueue<String> list;
    private Logger logger = LoggerFactory.getLogger(ThreadLogger.class);

    public Logging(ConcurrentLinkedQueue list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (!list.isEmpty()) {
                    if (list.size() <= 5) Thread.sleep(100);
                    logger.info(list.poll());
                }
            } catch (InterruptedException e) {
            }
        }
    }
}
