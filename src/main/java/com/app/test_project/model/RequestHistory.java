package com.app.test_project.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "REQUEST_HIST")
public class RequestHistory {
    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private RequestType type;

    @Column(name = "DT")
    private LocalDateTime date;

    @Column(name = "DESCR")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RequestType getType() {
        return type;
    }

    public void setType(RequestType type) {
        this.type = type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
