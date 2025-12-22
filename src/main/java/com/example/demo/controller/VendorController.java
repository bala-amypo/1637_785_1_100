package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.entity.Vendor;
import com.example.demo.repository.VendorRepository;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    @Autowired
    private VendorRepository vendorRepository;

    @PostMapping("/save")
    public Vendor saveVendor(@RequestBody Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    @GetMapping("/all")
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }
}
