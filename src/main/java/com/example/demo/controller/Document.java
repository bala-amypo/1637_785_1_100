package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.entity.DocumentType;
import com.example.demo.repository.DocumentTypeRepository;

@RestController
@RequestMapping("/document-types")
public class DocumentTypeController {

    @Autowired
    private DocumentTypeRepository repository;

    @PostMapping("/save")
    public DocumentType save(@RequestBody DocumentType documentType) {
        return repository.save(documentType);
    }

    @GetMapping("/all")
    public List<DocumentType> getAll() {
        return repository.findAll();
    }
}
