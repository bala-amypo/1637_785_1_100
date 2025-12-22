package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.ComplianceRule;

public interface ComplianceRuleService {

    ComplianceRule save(ComplianceRule rule);

    List<ComplianceRule> getAll();
}
