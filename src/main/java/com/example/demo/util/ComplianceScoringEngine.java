package com.example.demo.util;

import com.example.demo.model.DocumentType;
import com.example.demo.model.VendorDocument;

import java.util.List;

public class ComplianceScoringEngine {

    public double calculateScore(List<DocumentType> documentTypes, List<VendorDocument> vendorDocuments) {
        // Example logic
        double score = 0.0;
        // calculate based on documents
        return score;
    }

    public String deriveRating(double score) {
        if (score >= 80) return "A";
        if (score >= 50) return "B";
        return "C";
    }
}
