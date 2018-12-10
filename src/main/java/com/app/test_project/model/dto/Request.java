package com.app.test_project.model.dto;

import com.app.test_project.model.RequestType;

public interface Request {
    RequestType getType();
    String getDescription();
}
