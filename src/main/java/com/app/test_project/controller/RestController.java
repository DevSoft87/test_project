package com.app.test_project.controller;

import com.app.test_project.model.dto.CounterDto;
import com.app.test_project.model.dto.IncreaseThreadRequestDto;
import com.app.test_project.service.CounterService;
import com.app.test_project.service.RequestSaverService;
import com.app.test_project.service.ThreadContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.nonNull;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired private CounterService counterService;
    @Autowired private ThreadContainer threadContainer;
    @Autowired private RequestSaverService requestSaverService;

    @RequestMapping (value = "/threads/increase",
                    method = RequestMethod.POST,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void increaseThreads(@RequestBody IncreaseThreadRequestDto data) {
        threadContainer.addThreads(data);
    }

    @RequestMapping (value = "/counter",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void changeCounter(@RequestBody CounterDto data) {
        if (nonNull(data) && nonNull(data.getValue())) {
            counterService.setValue(data.getValue());
            requestSaverService.save(data);
        }
    }
}
