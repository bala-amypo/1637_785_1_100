package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.ComplianceRule;

public interface ComplianceRuleRepository extends JpaRepository<ComplianceRule, Long> {

    boolean existsByRuleName(String ruleName);
}
