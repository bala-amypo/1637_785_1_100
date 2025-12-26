package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.VendorDocument;

public interface VendorDocumentService {

    VendorDocument save(VendorDocument document);

    List<VendorDocument> getAll();
}
