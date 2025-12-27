package com.example.demo.service.impl;

import com.example.demo.model.ComplianceScore;
import com.example.demo.service.ComplianceScoreService;
import org.springframework.stereotype.Service;

@Service
public class ComplianceScoreServiceImpl implements ComplianceScoreService {

    @Override
    public ComplianceScore getScore(Long id) {
       
        return new ComplianceScore(); 
    }

   
}
