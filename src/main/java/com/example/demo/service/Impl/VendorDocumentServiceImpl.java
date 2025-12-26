package com.example.demo.service.impl;

import com.example.demo.model.VendorDocument;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.service.VendorDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorDocumentServiceImpl implements VendorDocumentService {

    @Autowired
    private VendorDocumentRepository repository;

    @Override
    public VendorDocument getDocument(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public VendorDocument uploadDocument(Long vendorId, Long documentTypeId, VendorDocument doc) {
        repository.findByVendor(vendorId);
        repository.setDocumentTypeId(documentTypeId);
        return repository.save(doc);
    }
}
