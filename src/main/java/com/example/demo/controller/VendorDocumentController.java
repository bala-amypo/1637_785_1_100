package com.example.demo.controller;

import com.example.demo.model.VendorDocument;
import com.example.demo.service.VendorDocumentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/documents")
public class VendorDocumentController {

    private final VendorDocumentService service;

    public VendorDocumentController(VendorDocumentService service) {
        this.service = service;
    }

    @PostMapping("/{vendorId}/{typeId}")
    public VendorDocument upload(@PathVariable Long vendorId,
                                 @PathVariable Long typeId,
                                 @RequestBody VendorDocument doc) {
        return service.uploadDocument(vendorId, typeId, doc);
    }
}
