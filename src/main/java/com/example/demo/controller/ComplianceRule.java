package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.entity.ComplianceRule;
import com.example.demo.repository.ComplianceRuleRepository;

@RestController
@RequestMapping("/compliance-rules")
public class ComplianceRuleController {

    @Autowired
    private ComplianceRuleRepository repository;

    @PostMapping("/save")
    public ComplianceRule save(@RequestBody ComplianceRule rule) {
        return repository.save(rule);
    }

    @GetMapping("/all")
    public List<ComplianceRule> getAll() {
        return repository.findAll();
    }
}
