package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.entity.VendorDocument;
import com.example.demo.repository.VendorDocumentRepository;

@RestController
@RequestMapping("/vendor-documents")
public class VendorDocumentController {

    @Autowired
    private VendorDocumentRepository repository;

    @PostMapping("/save")
    public VendorDocument save(@RequestBody VendorDocument document) {
        return repository.save(document);
    }

    @GetMapping("/all")
    public List<VendorDocument> getAll() {
        return repository.findAll();
    }
}
