package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ComplianceRule;
import com.example.demo.repository.ComplianceRuleRepository;
import com.example.demo.service.ComplianceRuleService;

@Service
public class ComplianceRuleServiceImpl implements ComplianceRuleService {

    @Autowired
    private ComplianceRuleRepository repository;

    @Override
    public ComplianceRule save(ComplianceRule rule) {
        return repository.save(rule);
    }

    @Override
    public List<ComplianceRule> getAll() {
        return repository.findAll();
    }
}
