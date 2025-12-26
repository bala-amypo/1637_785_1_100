package com.example.demo.service;

import com.example.demo.model.VendorDocument;

public interface VendorDocumentService {
    VendorDocument uploadDocument(Long vendorId, Long typeId, VendorDocument doc);
    VendorDocument getDocument(Long id);
}
