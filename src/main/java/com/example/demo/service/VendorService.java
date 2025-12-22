package com.example.demo.service;

import com.example.demo.entity.VendorEntity;
import java.util.List;

public interface VendorService {
    VendorEntity postData(VendorEntity stu);
    List<VendorEntity> getAllData();
    VendorEntity getData(int id);
    VendorEntity updateData(int id, VendorEntity entity);
    Vendor deleteData(int id);
}
