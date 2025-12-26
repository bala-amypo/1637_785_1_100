package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.util.ComplianceScoringEngine;

import java.util.List;

public class ComplianceScoreServiceImpl {

    private final VendorRepository vendorRepo;
    private final DocumentTypeRepository typeRepo;
    private final VendorDocumentRepository docRepo;
    private final ComplianceScoreRepository scoreRepo;
    private final ComplianceScoringEngine engine = new ComplianceScoringEngine();

    public ComplianceScoreServiceImpl(
            VendorRepository v,
            DocumentTypeRepository t,
            VendorDocumentRepository d,
            ComplianceScoreRepository s
    ) {
        vendorRepo = v;
        typeRepo = t;
        docRepo = d;
        scoreRepo = s;
    }

    public ComplianceScore evaluateVendor(Long vendorId) {
        Vendor v = vendorRepo.findById(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));

        List<DocumentType> required = typeRepo.findByRequiredTrue();
        List<VendorDocument> docs = docRepo.findByVendor(v);

        double score = engine.calculateScore(required, docs);
        ComplianceScore cs = scoreRepo.findByVendor_Id(vendorId).orElse(new ComplianceScore());

        cs.setVendor(v);
        cs.setScoreValue(score);
        cs.setRating(engine.deriveRating(score));

        return scoreRepo.save(cs);
    }

    public ComplianceScore getScore(Long vendorId) {
        return scoreRepo.findByVendor_Id(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("Score not found"));
    }
}
