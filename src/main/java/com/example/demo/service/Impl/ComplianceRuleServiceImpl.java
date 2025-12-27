package com.example.demo.service.impl;

import com.example.demo.model.ComplianceRule;
import com.example.demo.service.ComplianceRuleService;
import org.springframework.stereotype.Service;

@Service
public class ComplianceRuleServiceImpl implements ComplianceRuleService {

    @Override
    public ComplianceRule save(ComplianceRule rule) {
       
        return rule; 
    }

   
}
