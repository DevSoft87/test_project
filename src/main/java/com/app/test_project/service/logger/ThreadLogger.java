package com.app.test_project.service.logger;

import org.springframework.stereotype.Service;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class ThreadLogger {

    private ConcurrentLinkedQueue l = new ConcurrentLinkedQueue<String>();

    public ThreadLogger() {
        new Thread(new Logging(l)).start();
    }

    public void add(String msg) {
        l.add(msg);
    }

}
