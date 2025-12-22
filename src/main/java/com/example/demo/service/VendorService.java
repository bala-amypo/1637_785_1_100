package com.example.demo.service;

import com.example.demo.entity.VendorEntity;
import java.util.List;

public interface VendorService {
    VendorEntity postData(VendorEntity stu);
    List<VendorEntity> getAllData();
    StudentEntity getData(int id);
    StudentEntity updateData(int id, StudentEntity entity);
    String deleteData(int id);
}
