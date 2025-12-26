package com.example.demo.service;

import com.example.demo.model.VendorDocument;

public interface VendorDocumentService {

    VendorDocument getDocument(Long id);

    VendorDocument uploadDocument(Long vendorId, Long documentTypeId, VendorDocument doc);

} 
