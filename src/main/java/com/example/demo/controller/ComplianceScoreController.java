package com.example.demo.controller;

import com.example.demo.service.ComplianceScoreService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComplianceScoreController {

    private final ComplianceScoreService complianceScoreService;

    public ComplianceScoreController(ComplianceScoreService complianceScoreService) {
        this.complianceScoreService = complianceScoreService;
    }

    // Controller methods using complianceScoreService
}
