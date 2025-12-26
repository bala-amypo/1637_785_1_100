package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;

import java.time.LocalDate;

public class VendorDocumentServiceImpl {

    private final VendorDocumentRepository docRepo;
    private final VendorRepository vendorRepo;
    private final DocumentTypeRepository docTypeRepo;

    public VendorDocumentServiceImpl(
            VendorDocumentRepository d,
            VendorRepository v,
            DocumentTypeRepository t
    ) {
        docRepo = d;
        vendorRepo = v;
        docTypeRepo = t;
    }

    public VendorDocument uploadDocument(Long vendorId, Long typeId, VendorDocument doc) {

        if (doc.getExpiryDate().isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Expiry date cannot be in the past");

        Vendor v = vendorRepo.findById(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));

        DocumentType dt = docTypeRepo.findById(typeId)
                .orElseThrow(() -> new ResourceNotFoundException("DocumentType not found"));

        doc.setVendor(v);
        doc.setDocumentType(dt);
        return docRepo.save(doc);
    }

    public VendorDocument getDocument(Long id) {
        return docRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VendorDocument not found"));
    }
}
