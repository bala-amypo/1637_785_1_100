package com.example.demo.service;

import com.example.demo.model.Vendor;
import java.util.List;

public interface VendorService {
    Vendor findById(Long id);
    List<Vendor> findAll();
    Vendor save(Vendor vendor);
}
