package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ComplianceRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private String matchType;
    private Double threshold = 0.0;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        if (threshold == null) threshold = 0.0;
    }

    // getters/setters
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }
    public void setMatchType(String matchType) { this.matchType = matchType; }
    public Double getThreshold() { return threshold; }
}
