package com.example.demo.controller;

import com.example.demo.service.ComplianceRuleService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComplianceRuleController {

    private final ComplianceRuleService complianceRuleService;

    public ComplianceRuleController(ComplianceRuleService complianceRuleService) {
        this.complianceRuleService = complianceRuleService;
    }
}
