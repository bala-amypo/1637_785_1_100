package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.VendorEntity;
import com.example.demo.repository.VendorRepository;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepository repo;

    @Override
    public VendorEntity saveVendor(VendorEntity vendor) {
        return repo.save(vendor);
    }

    @Override
    public List<VendorEntity> getAllVendors() {
        return repo.findAll();
    }

    @Override
    public VendorEntity getVendorById(int id) {
        return repo.findById(id).orElse(null);
    }
}
