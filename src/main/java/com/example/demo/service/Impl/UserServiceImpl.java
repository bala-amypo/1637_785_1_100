package com.example.demo.service.impl;

import com.example.demo.model.Vendor;
import com.example.demo.service.VendorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service  // THIS IS CRUCIAL
public class VendorServiceImpl implements VendorService {

    private final List<Vendor> vendors = new ArrayList<>();

    @Override
    public Vendor findById(Long id) {
        return vendors.stream().filter(v -> v.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Vendor> findAll() {
        return vendors;
    }

    @Override
    public Vendor save(Vendor vendor) {
        vendors.add(vendor);
        return vendor;
    }
}
