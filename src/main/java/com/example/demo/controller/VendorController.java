package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.VendorEntity;
import com.example.demo.service.VendorService;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    private VendorService service;

    @PostMapping("/save")
    public VendorEntity saveVendor(@RequestBody VendorEntity vendor) {
        return service.saveVendor(vendor);
    }

    @GetMapping("/all")
    public List<VendorEntity> getAllVendors() {
        return service.getAllVendors();
    }

    @GetMapping("/{id}")
    public VendorEntity getVendor(@PathVariable int id) {
        return service.getVendorById(id);
    }
}
