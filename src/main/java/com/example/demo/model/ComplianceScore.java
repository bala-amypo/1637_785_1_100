package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class ComplianceScore {
    private Long id;
    private double score;

    public ComplianceScore() {}

    public ComplianceScore(Long id, double score) {
        this.id = id;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
