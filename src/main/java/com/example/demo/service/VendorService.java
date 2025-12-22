package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.VendorEntity;

public interface VendorService {

    VendorEntity saveVendor(VendorEntity vendor);
    List<VendorEntity> getAllVendors();
    VendorEntity getVendorById(int id);
}
