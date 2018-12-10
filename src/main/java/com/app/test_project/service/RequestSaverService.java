package com.app.test_project.service;

import com.app.test_project.model.RequestHistory;
import com.app.test_project.model.dto.Request;
import com.app.test_project.repository.RequestSaverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class RequestSaverService {

    @Autowired
    private RequestSaverRepository requestSaverRepository;

    public void save(Request request) {
        RequestHistory hist = new RequestHistory();
        hist.setType(request.getType());
        hist.setDate(LocalDateTime.now());
        hist.setDescription(request.getDescription());
        requestSaverRepository.save(hist);
    }
}
